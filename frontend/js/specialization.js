const table=document.getElementById('doctor-specialization-table')
const template=document.getElementById('doctor-specialization')

fetch('http://localhost:8080/api/doctor-specialization')
    .then(rsp => rsp.json())
    .then(data => {
        data.forEach(doctorSpecialization=> {
            const copy = template.content.cloneNode(true)
            copy.querySelector('.id').innerText=doctorSpecialization.id
            copy.querySelector('.name').innerText=doctorSpecialization.name
            copy.querySelector('.created').innerText=formatDate(doctorSpecialization.createdAt)
            copy.querySelector('.updated').innerText=formatDate(doctorSpecialization.updatedAt)
             copy.querySelector('.edit').href = `./edit-doctor-specialization.html?id=${doctorSpecialization.id}`
            copy.querySelector('.remove').addEventListener('click', ()=>{
                if(confirm(`Želite obrisati ${doctorSpecialization.name}`)){
                    fetch(`http://localhost:8080/api/doctor-specialization/${doctorSpecialization.id}`,{
                        method:'delete',
                    })
                        .then(rsp=>{
                            if(rsp.status === 204){
                                window.location.href='./doctor-specialization.html'
                                return
                            }
                            alert(`Brisanje specijalizacije nije uspelo!(HTTP${rsp.status})`)
                        })
                }
            })
            table.appendChild(copy)

        })
    })