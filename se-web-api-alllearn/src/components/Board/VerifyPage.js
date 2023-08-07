import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { padding } from '@mui/system';



function VerifyPage() {

    const classes = useStyles();

    return (

        <div className={classes.verifyPage}>

            <div className={classes.verifyCon}>


                <div className={classes.verifyUpBut}>

                    <Button
                        variant="contained"
                        component="label"
                        color='tertiary'
                        size="large"
                    >
                        Upload Certificate
                        <input hidden accept="image/*" multiple type="file" />
                    </Button>

                </div>


                <div className={classes.verifyInfo}>

                    <a className='a'>คำอธิบายเพิ่มเติม</a>

                    <TextField
                        id="outlined-textarea"
                        label="คำอธิบาย"
                        placeholder="คำอธิบายเพิ่มเติม"
                        multiline
                    />

                    <div className={classes.verbutton}>
                        <Button
                            variant="contained"
                            color='primary'
                            size="large"
                        >
                            Post
                        </Button>
                    </div>

                </div>




            </div>

        </div>



    )
}

const useStyles = makeStyles((theme) => ({

    verifyPage: {
        display: 'grid',
        justifyContent: 'center',


    },
    verifyCon: {
        display: 'grid',
        marginTop: '10%',


    },


    verifyInfo: {
        display: 'grid',
        width: '1000px',
        height: '100px',
        marginTop: '20px',
        /* padding-inline: 300px; */
        gap:'10px',
        fontSize: '28px',
        fontWeight: 'bold',


    },
    verbutton: {
        display: "flex",
        justifyContent: 'end',
        marginTop: '50px',
        marginBottom: '40px',

    },
    verifyUpBut: {
        marginButton: '40px',

    },





}));

export default VerifyPage