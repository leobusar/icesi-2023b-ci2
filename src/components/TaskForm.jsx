import React, { useState } from 'react'
import PropTypes from 'prop-types'
import { Box, Button, TextField, FormControlLabel, Checkbox } from '@mui/material'

function TaskForm({addTask}) {
   // const [id, setId] =  useState('')
    const [title, setTitle] =  useState('')
    const [userId , setUserId] =  useState('')
    const [completed, setCompleted] =  useState(false)

    const handleClick = (e)=>{
        //e.preventDefault()
        addTask({title, userId, completed})
        
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
      <FormControlLabel control={<Checkbox checked={completed} onChange={(e)=>{setCompleted(!completed)}}/>} label="Completed" />
      <Button variant="contained" onClick={handleClick}>Save</Button>
    </Box>
  )
}

TaskForm.propTypes = {
    addTask: PropTypes.func
}

export default TaskForm
