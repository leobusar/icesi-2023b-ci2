import React from 'react'
import taskList from  '../data/todos.json'
import TaskTable from '../components/TaskTable'

function TaskList({owner}) {

  const  renderTasks = () => {
    return  taskList.map((task)=>

         (<li key={task.id}>
            {task.title}
        </li>)
    )
  }
  console.log(taskList)  
  return (
    <div>{owner}'s TaskList
        <TaskTable taskList={taskList}/>
    </div>
  )
}

export default TaskList