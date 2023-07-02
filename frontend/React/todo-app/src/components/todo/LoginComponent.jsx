import {useNavigate} from 'react-router-dom'
import { useState } from 'react'

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

export default LoginComponent