import { useParams } from "react-router"

function AboutParams() {
   let  {id} =  useParams();  
  return (
    <div>About Perfil: {id}</div>
  )
}

export default AboutParams