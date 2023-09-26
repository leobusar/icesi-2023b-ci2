import {useState} from 'react'
import tasks from  '../data/todos.json'
import TaskTable from '../components/TaskTable'
import TaskForm from '../components/TaskForm'
import PropTypes from 'prop-types'

function TaskList({owner}) {

  const [taskList, setTaskList] = useState(tasks)
  const [taskEdit, setTaskEdit] = useState({id:"", title:"", completed: false, userId:""})

  const addTask = (task) => {
    let taskTmp = [...taskList]

    if (task.id==""){
      task.id= Math.floor(Math.random()*100000)
      taskTmp.push(task)
    }else{
      let index = taskList.findIndex(elem => elem.id==task.id)
      taskTmp[index] = task
    }  
    setTaskList(taskTmp)
  }

  const delTask =  (id) => {
    let index = taskList.findIndex(task => task.id==id)
    taskList.splice(index,1);
    let taskTmp = [...taskList]

    setTaskList(taskTmp)
    //setTaskList(taskList.filter(task => task.id!=id))
  }

  return (
    <div>{owner}s TaskList
      <TaskForm addTask={addTask} taskEdit={taskEdit}/>
      <TaskTable taskList={taskList} delTask={delTask} editTask={setTaskEdit}/>
    </div>
  )
}

TaskList.propTypes = {
  owner: PropTypes.string
}

export default TaskList