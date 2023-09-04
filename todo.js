let url="http://localhost:3000";
//let todos  = []

async function renderData(todos){
    let  tasksHtml = await todos.map(
        (task) => `<ul class="list-group list-group-horizontal rounded-0 bg-transparent taskElement" id="${task.id}">
        <li
          class="list-group-item d-flex align-items-center ps-0 pe-3 py-1 rounded-0 border-0 bg-transparent">
          <div class="form-check">
            <input class="form-check-input me-0" type="checkbox" value="" aria-label="..." checked="${task.completed}" />
          </div>
        </li>
        <li
          class="list-group-item px-3 py-1 d-flex align-items-center flex-grow-1 border-0 bg-transparent">
          <p class="lead fw-normal mb-0">${task.description}</p>
        </li>
        <li class="list-group-item ps-3 pe-0 py-1 rounded-0 border-0 bg-transparent">
          <div class="d-flex flex-row justify-content-end mb-1">
            <a href="#!" class="text-info" data-mdb-toggle="tooltip" title="Edit todo"><i
                class="fas fa-pencil-alt me-3"></i></a>
            <a href="#!" class="text-danger" data-mdb-toggle="tooltip" title="Delete todo"><i
                class="fas fa-trash-alt"></i></a>
          </div>
          <div class="text-end text-muted">
            <a href="#!" class="text-muted" data-mdb-toggle="tooltip" title="Created date">
              <p class="small mb-0"><i class="fas fa-info-circle me-2"></i>${task.created_at}</p>
            </a>
          </div>
        </li>
      </ul>
        `
    )

    let taskHTMLelem = await document.querySelector(".text-danger")
    for (let i = taskHTMLelem.length-1; i >=0; i--){
        taskHTMLelem[i].addEventListener("click", function(){
            console.log(taskHTMLelem.id)
        })
    }


    let  taskDiv = document.getElementById("taskHTML")
    taskDiv.innerHTML =  tasksHtml;
}

function  fetchData(){
    fetch(url+"/task")
    .then ((res)=> 
        res.json()
    )
    .then ( json =>{
        let todos = json
        renderData(todos)
    })
}

fetchData();

function deleteTodo(id){
    console.log(id)
}
