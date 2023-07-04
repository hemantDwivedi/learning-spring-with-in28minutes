import { useNavigate, useParams } from "react-router-dom"
import { retrieveTodoApi, updateTodoApi } from "./api/TodoApiService"
import { useAuth } from "./security/AuthContext"
import { useEffect, useState } from "react"
import { Formik, Form, Field, ErrorMessage } from 'formik'

function TodoComponent() {

    const { id } = useParams()
    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState('')
    const navigate = useNavigate()
    const authContext = useAuth()
    const username = authContext.username

    useEffect(
        () => retrieveTodo(),
        [id]
    )

    function retrieveTodo() {
        retrieveTodoApi(username, id)
            .then(response => {
                setDescription(response.data.description)
                setTargetDate(response.data.targetDate)
            })
            .catch(error => console.log(error))
    }

    function onSubmit(values) {

        const todo = {
            id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        }

        updateTodoApi(username, id, todo)
            .then(
                navigate('/todos')
            )
            .catch(
                error => console.log(error)
            )
    }

    function validate(values) {
        let errors = {}

        if (values.description.length < 5) {
            errors.description = 'Enter atleast five characters'
        }

        if (values.targetDate == null) {
            errors.targetDate = 'enter a target date'
        }
        return errors
    }

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>
                <Formik initialValues={{ description, targetDate }}
                    enableReinitialize={true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage name="description" component="div" className="alert alert-warning" />
                                <ErrorMessage name="targetDate" component="div" className="alert alert-warning" />
                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field type="text" className="form-control" name="description" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target Date</label>
                                    <Field type="date" className="form-control" name="targetDate" />
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}

export default TodoComponent