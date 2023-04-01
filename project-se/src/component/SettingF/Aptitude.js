import Setting from './Setting'
import './Aptitude.css'
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';

function Save() {
    alert('You have successfully submitted your verification Aptitude Tags confirmation.');
}


function Aptitude() {
    return (
        <dev>
            <dev><Setting />
                <dev >
                    <dev className="container">
                        <dev ><h1 className="font">Aptitude Tags</h1>
                            <dev >
                                <Button
                                    variant="outlined"
                                    component="label"
                                    color='secondary'
                                    size="medium"
                                >
                                    UpLoad certificate:  . 
                                    <input  accept="pdf/*" multiple type="file" />
                                </Button>
                            </dev>
                        </dev>

                        <div className='topic'>

                            <a className='a'>Title</a>

                            <TextField
                                id="outlined-basi"
                                label="Title"
                                variant="outlined"
                            />

                        </div>
                        <div className='content'>

                            <a className='a'>About Me</a>

                            <TextField
                                id="outlined-basi"
                                label="write about yourself"
                                multiline
                                variant="outlined"

                            />
                            <dev>
                                <button className="buttonsave" onClick={Save}>Sent</button>
                            </dev>
                        </div>




                    </dev>
                </dev>
            </dev>


        </dev>
    )


}

export default Aptitude




