import React, {useState} from 'react'
import tasks from  '../data/todos.json'
import TaskTable from '../components/TaskTable'
import TaskForm from '../components/TaskForm'

function TaskList({owner}) {

  const [taskList, setTaskList] = useState(tasks) 
  const addTask = (task) => {
    task.id= Math.floor(Math.random()*100000)
    console.log(task)
    let taskTmp = [...taskList]
    taskTmp.push(task)
    setTaskList(taskTmp)
  }

  return (
    <div>{owner}'s TaskList
      <TaskForm addTask={addTask}/>
      <TaskTable taskList={taskList}/>
    </div>
  )
}

export default TaskList