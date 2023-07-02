import { useState } from 'react'
import './TodoApp.css'
import { BrowserRouter, Link, Route, Routes, useNavigate, useParams } from 'react-router-dom'

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <HeaderComponent />

            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<LoginComponent />} />
                    <Route path='/login' element={<LoginComponent />} />
                    <Route path='/welcome/:username' element={<WelcomeComponent />} />
                    <Route path='/todos' element={<ListTodosComponent />} />
                    <Route path='/logout' element={<LogoutComponent />} />


                    <Route path='*' element={<ErrorComponent />} />
                </Routes>
            </BrowserRouter>

            <FooterComponent />
        </div>
    )
}

function LoginComponent() {

    const [username, setUser] = useState('hemant')
    const [password, setPassword] = useState('')
    const [showSuccessMessage, setShowSuccessMessage] = useState(false)
    const [showErrorMessage, setShowErrorMessage] = useState(false)
    const navigate = useNavigate();

    function handleUsernameChange(event) {
        setUser(event.target.value)
    }


    function handlePasswordChange(event) {
        console.log(event.target.value)
        setPassword(event.target.value)
    }


    function handleSubmit() {
        if (username === 'hemant' && password === '12345') {
            setShowSuccessMessage(true)
            setShowErrorMessage(false)
            navigate(`/welcome/${username}`)
        }
        else {
            setShowSuccessMessage(false)
            setShowErrorMessage(true)
            navigate('/login')
        }
    }

    return (
        <div className="Login">
            {showSuccessMessage && <div className="successMessage">Authenticated Successfully</div>}
            {showErrorMessage && <div className="errorMessage">Authenticated Failed. Please check your credentials</div>}
            <h1>Login Page</h1>
            <div className="LoginForm">
                <div>
                    <label>Username</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )
}


function WelcomeComponent() {
    const { username } = useParams();
    return (
        <div className='WelcomeComponent'>
            <h1>Welcome {username}</h1>
            <div>
                Manage Your Todos <Link to="/todos">Go here</Link>
            </div>
        </div>
    )
}


function ErrorComponent() {
    return (
        <div className="ErrorComponent">
            <h1>Oops!</h1>
            <h3>404 - PAGE NOT FOUND</h3>
            <div>
                THE PAGE REQUESTED COULD NOT FOUND
            </div>
        </div>
    )
}


function ListTodosComponent() {


    const today = new Date();
    const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDay())

    const todos = [
        { id: 1, description: 'Learn DevOps', done: false, targetDate: targetDate },
        { id: 2, description: 'Learn Microservices', done: false, targetDate: targetDate },
        { id: 3, description: 'Learn AWS', done: false, targetDate: targetDate }
    ]

    return (
        <div className="ListTodosComponent">
            <h1>THINGS TO DO</h1>
            <div>
                <table>
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>DESCRIPTION</td>
                            <td>IS DONE</td>
                            <td>TARGET DATE</td>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            todos.map(todo => (
                                <tr key={todo.id}>
                                    <td>
                                        {todo.id}
                                    </td>
                                    <td>
                                        {todo.description}
                                    </td>
                                    <td>
                                        {todo.done.toString()}
                                    </td>
                                    <td>
                                        {todo.targetDate.toDateString()}
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

function HeaderComponent() {
    return (
        <div className="HeaderComponent">
            Header <hr />
        </div>
    )
}

function FooterComponent() {
    return (
        <div className="FooterComponent">
            Footer <hr />
        </div>
    )
}

function LogoutComponent() {
    return (
        <div className="LogoutComponent">
            You are logged out!
        </div>
    )
}