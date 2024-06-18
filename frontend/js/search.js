const searchInput = document.getElementById('search')
//window.location.search(?id=1)
const params=new URLSearchParams(window.location.search)
const searchParam= params.get('search')



if(searchParam != null && searchParam !=='')
    searchInput.value=searchParam

searchInput.addEventListener('keypress', (e) =>{
    if(e.key === 'Enter') goSearch()
})

document.getElementById('search-btn')
    .addEventListener('click',()=>{
    goSearch()
    })

function goSearch(){
    if(searchInput.value === '')return
    window.location.href=`./index.html?search=${search.value}`
}

function formatDate(iso){
    if(iso=== null)return'N/A'
    return new Date (iso).toLocaleString('sr-RS')
}