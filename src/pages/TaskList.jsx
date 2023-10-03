import {useEffect, useState} from 'react'
//import tasks from  '../data/todos.json'
import axios from  '../config/axios'
import TaskTable from '../components/TaskTable'
import TaskForm from '../components/TaskForm'
import PropTypes from 'prop-types'
import { TaskContext } from '../context/TaskContext'

function TaskList({owner}) {

  const [taskList, setTaskList] = useState([])
  const [taskEdit, setTaskEdit] = useState({id:"", title:"", completed: false, userId:""})

  const getTasks = async () => {
    try {
      /*axios.get("/tasks")
        .then ( (res)=> {
          console.log(res.data)
          setTaskList(res.data)
        })
        */
       const res = await axios.get("/tasks")
       setTaskList(res.data)
    }catch(e){
      console.log(e)
    }
  }

  useEffect( () => {getTasks()}, [])

  const addTask = async (task) => {
//    let taskTmp = [...taskList]

    if (task.id==""){
      task.id= Math.floor(Math.random()*100000)
      //taskTmp.push(task)
      try{
        const res = await axios.post("/tasks", task)
        if(res.status==201)
          getTasks()
      }catch (e){
        console.log(e)
      }
    }else{
      //let index = taskList.findIndex(elem => elem.id==task.id)
      //taskTmp[index] = task
      try{
        const res = await axios.put("/tasks/"+task.id, task)
        if(res.status==200)
          getTasks()
      }catch (e){
        console.log(e)
      }

    }  
    //setTaskList(taskTmp)
  }

  const delTask = async (id) => {
    // let index = taskList.findIndex(task => task.id==id)
    // taskList.splice(index,1);
    // let taskTmp = [...taskList]

    // setTaskList(taskTmp)
    //setTaskList(taskList.filter(task => task.id!=id))
    try {
      const res = await axios.delete("/tasks/"+id)
      if(res.status==200)
        getTasks()
    }catch (e){
      console.log(e)
    }
  }

  return (
    <TaskContext.Provider value={{taskEdit, setTaskEdit}}>
      
      {owner}s TaskList
      <TaskForm addTask={addTask} taskEdit={taskEdit}/>
      <TaskTable taskList={taskList} delTask={delTask} editTask={setTaskEdit}/>
    </TaskContext.Provider>
  )
}

TaskList.propTypes = {
  owner: PropTypes.string
}

export default TaskList