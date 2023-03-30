import React, { useState } from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
// import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import { Link } from '@material-ui/core';
import swal from 'sweetalert';
import { useNavigate } from 'react-router-dom';

async function loginUser(credentials) {
  return fetch('https://www.mecallapi.com/api/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(credentials)
  })
    .then(data => data.json())
}

export default function Signin() {
  const classes = useStyles();
  const [username, setUserName] = useState();
  const [password, setPassword] = useState();

  let navigate = useNavigate()

  const handleSubmit = async e => {
    e.preventDefault();
    const response = await loginUser({
      username,
      password
    });
    if ('accessToken' in response) {
      swal("Success", response.message, "success", {
        buttons: false,
        timer: 2000,
      })
        .then((value) => {
          localStorage.setItem('accessToken', response['accessToken']);
          localStorage.setItem('user', JSON.stringify(response['user']));
          window.location.href = "/profile";
        });
    } else {
      swal("Failed", response.message, "error");
    }
  }

  return (
    <Grid container className={classes.root}>
      {/* <CssBaseline /> */}

     {/* <Grid item xs={false} md={4} className={classes.image} /> */}
      {/* <Grid item xs={12} md={4} component={Paper} elevation={10} square> */}
      <Grid item xs={12} md={4}>
      
        <div className={classes.paper}>

          <Avatar className={classes.avatar}>
            <img src="./LogoV1.png" alt="bug" height={40} />
          </Avatar>

          <Typography component="h1" variant="h5">
            Log in
          </Typography>

          <form className={classes.form} noValidate onSubmit={handleSubmit}>
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              id="email"
              name="email"
              label="Email Address"
              onChange={e => setUserName(e.target.value)}
            />
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              id="password"
              name="password"
              label="Password"
              type="password"
              onChange={e => setPassword(e.target.value)}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              // className={classes.submit}
              onClick={() => navigate("/homepage")}
            >
              Log in
            </Button>

            {/* <Button
              fullWidth
              variant="contained"
              color="redA"
              // className={classes.submit}
              onClick={() => navigate("/register")}
              style={{marginTop:'10px'}}
            >
              Sing up
            </Button> */}
            <Grid container style={{ marginTop: '15px' }}>
              <Grid item>
                <Link href="/register" variant="body2">
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </form>
        </div>
      </Grid>
    </Grid>
  );
}

const useStyles = makeStyles((theme) => ({

  root: {

    height: '768px',
    display:'flex',
    justifyContent:'center',
    background: 'linear-gradient(#003566, #fff)',
    
   
    // backgroundColor:'green',
  },
  image: {
    backgroundImage: 'url(https://source.unsplash.com/random)',
    backgroundSize: 'cover',
  },
  paper: {
    backgroundColor:'white',
    margin: theme.spacing(8,4),
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',

    filter: 'drop-shadow(0px 2px 8px rgba(0,0,0,0.32))',
    padding:'40px',
    borderRadius:'20px',
   
    

  },
  avatar: {
   
    margin: theme.spacing(1),
    // borderRadius :10,
    backgroundColor: theme.palette.secondary.main,
  },
  form: {

    width: '100%',
    marginTop: theme.spacing(1),


  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));