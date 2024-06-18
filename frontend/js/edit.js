const id = params.get('id')

if(id === null || id === '')
    window.location.href='./index.html'

const breadcrumb=document.getElementById('breadcrumb')
const doctorId=document.getElementById('id')
const name=document.getElementById('name')
const surname=document.getElementById('surname')
const specialization=document.getElementById('specialization')
const jmbg=document.getElementById('jmbg')
const created=document.getElementById('created')
const updated=document.getElementById('updated')




//Ako gore ukucamo edit.html?id=npr67...
fetch('http://localhost:8080/api/doctor/' +id)
.then(rsp=>{
    if(rsp.status === 200)
        return rsp.json()
    alert('Doktor ne postoji!')
    window.location.href='./index.html'
})
.then(data=>{
    //breadcrumb da posle početna piše početna/Vladimir Tomasevic npr..
    breadcrumb.innerText=`${data.name} ${data.surname}`
    doctorId.value=data.id
    name.value=data.name
    surname.value=data.surname
    jmbg.value=data.jmbg

    //Ucitavanje specijalizacija
    fetch('http://localhost:8080/api/doctor-specialization')
        .then(rsp=>rsp.json())
        .then(specializationData=>{
            specializationData.forEach(doctorSpecialization=>{
                const option=document.createElement('option')
                if(doctorSpecialization.id === data.doctorSpecialization.id){
                    option.selected=true
                }
                option.value= doctorSpecialization.id
                option.text=doctorSpecialization.name
                specialization.appendChild(option)
            })

        })

    created.value=formatDate(data.createdAt)
    updated.value=formatDate(data.updatedAt)

    document.getElementById('save').addEventListener('click', ()=>{
        fetch(`http://localhost:8080/api/doctor/${data.id}`,{
            method:'put',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name:name.value,
                surname:surname.value,
                jmbg:jmbg.value,
                doctorSpecializationId:specialization.value

            })

        })
            .then(rsp=>{
                if(rsp.ok){
                    window.location.href='./index.html'
                    return
                }
                alert(`Promena nije uspela!(HTTP${rsp.status})`)
                })

    })
})