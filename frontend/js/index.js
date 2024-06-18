const table = document.getElementById('table')
const template=document.getElementById('doctor')
const searchTitle=document.getElementById('search-title')

if(searchParam !==null && searchParam !== '') {
    searchTitle.innerText='Pretraga doktora'
    fetchDoctors('/jmbg/' + searchParam)
} else{
    searchTitle.innerText='Spisak doktora'
    fetchDoctors()
}


function fetchDoctors(url = ''){
    fetch(`http://localhost:8080/api/doctor${url}`)
        .then(rsp => rsp.json())
        .then(data => {
            if(data.lenght === 0){
                alert('Doktor ne postoji!')
                fetchDoctors()
                return
            }
            data.forEach(doctor => {
                const copy = template.content.cloneNode(true)
                copy.querySelector('.id').innerText=doctor.id
                copy.querySelector('.name').innerText=doctor.name
                copy.querySelector('.surname').innerText=doctor.surname
                copy.querySelector('.jmbg').innerText=doctor.jmbg
                copy.querySelector('.created').innerText=formatDate(doctor.createdAt)
                copy.querySelector('.updated').innerText=formatDate(doctor.updatedAt)
                copy.querySelector('.edit').href = `./edit.html?id=${doctor.id}`
                copy.querySelector('.remove').addEventListener('click', ()=>{
                    if(confirm(`Želite obrisati doktora${doctor.name} ${doctor.surname} ${doctor.jmbg}`)){
                        fetch(`http://localhost:8080/api/doctor/${doctor.id}`,{
                            method:'delete',
                        })
                            .then(rsp=>{
                                if(rsp.status == 204){
                                    window.location.href='./index.html'
                                    return
                                }
                                alert(`Brisanje nije uspelo!(HTTP${rsp.status})`)
                            })
                    }
                })
                table.appendChild(copy)

            })
        })

    function formatDate(iso){
        if(iso=== null)return'N/A'
        return new Date (iso).toLocaleString('sr-RS')
    }

}