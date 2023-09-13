import { TableContainer, TableRow, TableHead, Table,  TableCell, TableBody, Paper } from '@mui/material'
import PropTypes from 'prop-types'
import TaskRow from './TaskRow'

function  TaskTable ({taskList}) {

  const  renderTasks = () => {
    return  taskList.map((task)=>

         (<TaskRow key={task.id} task={task}/>)
    )
  }
  return (
    <TableContainer component={Paper}>
    <Table sx={{ minWidth: 650 }} aria-label="simple table">
      <TableHead>
        <TableRow>
          <TableCell>UserId</TableCell>
          <TableCell align="right">Id</TableCell>
          <TableCell align="left">Title</TableCell>
          <TableCell align="left">Completed</TableCell>

        </TableRow>
      </TableHead>
      <TableBody>
        {renderTasks()}
      </TableBody>
      </Table>
    </TableContainer>  
    )
}


TaskTable.propTypes = {
  taskList: PropTypes.array
}

export default TaskTable
