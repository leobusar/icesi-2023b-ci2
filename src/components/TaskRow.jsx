import PropTypes from 'prop-types'
import { TableRow, TableCell, Button, } from '@mui/material'

function TaskRow({task, delTask, editTask }) {
  const  handleDelete = () =>  {
    delTask(task.id)
  }
  return (
    <TableRow
          key={task.id}
          sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
        >
          <TableCell component="th" scope="row">
            {task.userId}
          </TableCell>
          <TableCell align="right">{task.id}</TableCell>
          <TableCell align="left">{task.title}</TableCell>
          <TableCell align="left">{task.completed+""}</TableCell>
          <TableCell align="left">
            <Button variant="contained" color="error" onClick={handleDelete}>Delete</Button>&nbsp;
            <Button variant="contained" color="success" onClick={()=>{editTask(task)}}>Edit</Button>
          </TableCell>
        </TableRow>  )
}

TaskRow.propTypes = {
    task: PropTypes.object,
    delTask: PropTypes.func,
    editTask: PropTypes.func
}

export default TaskRow
