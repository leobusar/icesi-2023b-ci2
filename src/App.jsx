import { useState } from 'react'
import './App.css'
import TaskList from './pages/TaskList'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <TaskList  owner="Leonardo" />
    </>
  )
}

export default App
