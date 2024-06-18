const id = params.get('id')

if(id === null || id === '')
    window.location.href='./index.html'

const breadcrumb=document.getElementById('breadcrumb')
const doctorId=document.getElementById('id')
const name=document.getElementById('name')
const created=document.getElementById('created')
const updated=document.getElementById('updated')

//Ako gore ukucamo edit.html?id=npr67...
fetch('http://localhost:8080/api/doctor-specialization/' +id)
    .then(rsp=>{
        if(rsp.status === 200)
            return rsp.json()
        alert('Doktor ne postoji!')
        window.location.href='./index.html'
    })
    .then(data=>{
        //breadcrumb da posle početna piše početna/Vladimir Tomasevic npr..
        breadcrumb.innerText=`${data.name}`
        doctorId.value=data.id
        name.value=data.name
        created.value=formatDate(data.createdAt)
        updated.value=formatDate(data.updatedAt)

        document.getElementById('save').addEventListener('click', ()=>{
            fetch(`http://localhost:8080/api/doctor-specialization/${data.id}`,{
                method:'put',
                headers:{
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    name:name.value,
                })

            })
                .then(rsp=>{
                    if(rsp.ok){
                        window.location.href='./doctor-specialization.html'
                        return
                    }
                    alert(`Promena nije uspela!(HTTP${rsp.status})`)
                })

        })
    })