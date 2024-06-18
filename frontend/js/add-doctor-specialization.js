const name=document.getElementById('name')


document.getElementById('save').addEventListener('click', ()=>{
    if(name.value===null || name.value===''){
        alert('Naziv specijalizacije doktora ne sme biti nepopunjen!')
        return
    }
    fetch('http://localhost:8080/api/doctor-specialization',{
        method:"POST",
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name:name.value,
        }),
    })  .then(rsp=>{
            if(rsp.ok){
                window.location.href='./doctor-specialization.html'
                return
            }
            alert(`Dodavanje specijalizacije doktora nije uspelo!(HTTP${rsp.status})`)
        }
    )
})

