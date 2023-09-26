import { useEffect, useState } from 'react'
import PropTypes from 'prop-types'
import { Box, Button, TextField, FormControlLabel, Checkbox } from '@mui/material'

function TaskForm({addTask, taskEdit}) {
    const [id, setId] =  useState('')
    const [title, setTitle] =  useState('')
    const [userId , setUserId] =  useState('')
    const [completed, setCompleted] =  useState(false)

    useEffect(()=>{
      setId(taskEdit.id)
      setTitle(taskEdit.title)
      setUserId(taskEdit.userId)
      setCompleted(taskEdit.completed)
      //console.log(taskEdit)
    }, [taskEdit])

    const handleClick = ()=>{
        //e.preventDefault()
        addTask({id,title, userId, completed})
    }

    return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField label="User Id" variant="standard" value={userId} onChange={(e)=>{setUserId(e.target.value)}}/>
      <TextField label="Title" variant="standard" value={title} onChange={(e)=>{setTitle(e.target.value)}}/>
      <FormControlLabel control={<Checkbox checked={completed} onChange={()=>{setCompleted(!completed)}}/>} label="Completed" />
      <Button variant="contained" onClick={handleClick}>Save</Button>
    </Box>
  )
}

TaskForm.propTypes = {
    addTask: PropTypes.func, 
    taskEdit:PropTypes.object
}

export default TaskForm
