import { useEffect, useState } from "react"
import { deleteTodoApi, retrieveAllTodosForUsernameApi } from "./api/TodoApiService"
import { useNavigate } from "react-router-dom"
import { useAuth } from "./security/AuthContext"

function ListTodosComponent() {

    const authContext = useAuth()
    const username = authContext.username
    const [todos, setTodos] = useState([])
    const [message, setMessage] = useState(null)
    const navigate = useNavigate()

    useEffect(() => refreshTodos(), [])

    function refreshTodos() {
        retrieveAllTodosForUsernameApi(username)
            .then(response => {
                setTodos(response.data)
            }
            )
            .catch(error => console.log(error))
    }

    function deleteTodo(id) {
        deleteTodoApi(username, id)
        .then (
            () => {
                setMessage(`Delete of todo with id ${id} successful`)
                refreshTodos()
            }
        )
        .catch ( error => console.log(error))
    }
    
    function updateTodo(id) {
        navigate(`/todo/${id}`)
    }
    
    
    function addNewTodo() {
        navigate(`/todo/-1`)
    }

    return (
        <div className="container">
            <h1>THINGS TO DO</h1>
            {message && <div className="alert alert-warning">{message}</div>}
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>DESCRIPTION</th>
                            <th>IS DONE</th>
                            <th>TARGET DATE</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            todos.map(todo => (
                                <tr key={todo.id}>
                                    <td>
                                        {todo.description}
                                    </td>
                                    <td>
                                        {todo.done.toString()}
                                    </td>
                                    <td>
                                        {/* {todo.targetDate.toDateString()} */}
                                        {todo.targetDate.toString()}
                                    </td>
                                    <td>
                                        <button className="btn btn-danger" onClick={() => deleteTodo(todo.id)}>Delete</button>
                                        <button className="btn btn-warning mx-2" onClick={() => updateTodo(todo.id)}>Update</button>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
                <div className="btn btn-success m-5" onClick={addNewTodo}>Add New Todo</div>
            </div>
        </div>
    )
}

export default ListTodosComponent