import { useEffect, useState } from "react"
import { deleteTodoApi, retrieveAllTodosForUserApi } from "./api/TodoApiService"

function ListTodosComponent() {

    const [todos, setTodos] = useState([])
    const [message, setMessage] = useState(null)

    useEffect(() => refreshTodos(), [])

    function refreshTodos() {
        retrieveAllTodosForUserApi('in28minutes')
            .then(response => {
                setTodos(response.data)
            }
            )
            .catch(error => console.log(error))
    }

    function deleteTodo(id) {
        deleteTodoApi('in28minutes', id)
        .then (
            () => {
                setMessage(`Delete of todo with id ${id} successful`)
                refreshTodos()
            }
        )
        .catch ( error => console.log(error))
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
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default ListTodosComponent