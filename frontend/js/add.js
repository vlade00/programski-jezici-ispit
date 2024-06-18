const name=document.getElementById('name')
const surname=document.getElementById('surname')
const jmbg=document.getElementById('jmbg')

document.getElementById('save').addEventListener('click', ()=>{
    if(name.value===null || name.value===''){
        alert('Ime doktora ne sme biti nepopunjeno!')
        return
    }
    if(surname.value===null || surname.value===''){
        alert('Prezime doktora ne sme biti nepopunjeno!')
        return
    }
    if(jmbg.value===null || jmbg.value===''){
        alert('Jmbg doktora ne sme biti nepopunjen!')
        return
    }
    fetch('http://localhost:8080/api/doctor',{
        method:"POST",
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name:name.value,
            surname:surname.value,
            jmbg:jmbg.value
        }),
    })  .then(rsp=>{
            if(rsp.ok){
                window.location.href='./index.html'
                return
            }
            alert(`Promena nije uspela!(HTTP${rsp.status})`)
        }
    )
})


