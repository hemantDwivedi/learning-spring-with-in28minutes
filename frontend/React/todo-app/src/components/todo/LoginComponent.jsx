import {useNavigate} from 'react-router-dom'
import { useState } from 'react'
import { useAuth } from './security/AuthContext'

function LoginComponent() {

    const [username, setUser] = useState('hemant')
    const [password, setPassword] = useState('')
    const [showErrorMessage, setShowErrorMessage] = useState(false)
    const navigate = useNavigate();
    const authContext = useAuth()

    function handleUsernameChange(event) {
        setUser(event.target.value)
    }


    function handlePasswordChange(event) {
        console.log(event.target.value)
        setPassword(event.target.value)
    }


    function handleSubmit() {
        if (authContext.login(username, password)) {
            navigate(`/welcome/${username}`)
        }
        else {
            setShowErrorMessage(true)
            navigate('/login')
        }
    }

    return (
        <div className="Login">
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
                    <button className='btn btn-success' type="button" name="login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )
}

export default LoginComponent