import { useState } from 'react';
import { useParams, Link } from 'react-router-dom'
import { retrieveHelloWorldBean, retrieveHelloWorldBeanPathVariable } from './api/HelloWorldApiService';

function WelcomeComponent() {
    const { username } = useParams();

    const [message, setMessage] = useState(null)

    const name = 'Hemant'

    function callHelloWorldApi() {

        retrieveHelloWorldBeanPathVariable('Hemant')
            .then((response) => successResponse(response))
            .catch((error) => errorResponse(error))
            .finally(() => console.log('cleanup'))
    }

    function successResponse(response) {
        console.log(response);
        console.log('success');
        setMessage(response.data.message)
    }

    function errorResponse(error) {
        console.log('failed');
    }

    return (
        <div className='WelcomeComponent'>
            <h1>Welcome {username}</h1>
            <div>
                Manage Your Todos <Link to="/todos">Go here</Link>
            </div>
            <div>
                <button className='btn btn-danger' onClick={callHelloWorldApi}>Hello World</button>
            </div>
            <div className='text-info' >{message}</div>
        </div>
    )
}

export default WelcomeComponent