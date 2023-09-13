import React from 'react'
import PropTypes from 'prop-types'
import { TableRow, TableCell, } from '@mui/material'

function TaskRow({task}) {
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
        </TableRow>  )
}

TaskRow.propTypes = {
    task: PropTypes.object
}

export default TaskRow
