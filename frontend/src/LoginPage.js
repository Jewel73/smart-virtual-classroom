import React, { useState } from 'react';
import { AppBar, Toolbar, Typography, Box, TextField, Button, Container, CssBaseline, Paper, Grid } from '@mui/material';
import { makeStyles } from '@mui/styles';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import logo from './logo.png'; // Adjust the path as necessary
import navbarlogo from './navbarlogo.jpg'; // Adjust the path as necessary
import { useDispatch } from 'react-redux';
import { addUser, updateUser } from './redux/slice/UserSlice';
import UserList from './pages/LoginPage/UserList';

const theme = createTheme();

const useStyles = makeStyles({
  root: {
    backgroundColor: '#f9f9f9',
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
  },
  navbar: {
    backgroundColor: '#fff',
    boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
  },
  container: {
    height: '100%',
    width: '100%',
    display: 'flex',
    backgroundColor: '#fff',
    boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
    borderRadius: '8px',
    overflow: 'hidden',
    marginTop: theme.spacing(10), // Adjusted to accommodate navbar height
  },
  leftSection: {
    padding: theme.spacing(6),
    flex: '1', // Added
    display: 'flex', // Added
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#fff',
  },
  rightSection: {
    padding: theme.spacing(6),
    backgroundColor: '#f4f6f8',
    flex: '1', // Added
    display: 'flex', // Added
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
  },
  loginForm: {
    width: '100%',
    maxWidth: '300px',
  },
  logo: {
    width: '600px',
    marginBottom: theme.spacing(4),
  },
  welcomeText: {
    display: 'inline-block',
    animation: '$slideInOut 3s infinite',
  },
  '@keyframes slideInOut': {
    '0%': {
      transform: 'translateX(50%)',
      opacity: 0,
    },
    '30%': {
      transform: 'translateX(0)',
      opacity: 0,
    },
    '70%': {
      transform: 'translateX(0)',
      opacity: 1,
    },
    '100%': {
      transform: 'translateX(-100%)',
      opacity: 0,
    },
  },
});


function LoginPage() {
  const classes = useStyles();

  const dispatch = useDispatch();
  const [name, setName] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch(addUser({ name }));
    setName('');
  };


  return (
    <ThemeProvider theme={theme}>
      <div className={classes.root}>
        <CssBaseline />
        <AppBar position="fixed" className={classes.navbar}>
          <Toolbar>
            <img src={navbarlogo} alt="Logo" style={{ height: 30 }} />
            <Box flexGrow={1} />
            <Button color="inherit">Registration</Button>
          </Toolbar>
        </AppBar>
        <Container className={classes.container} component={Paper}>
          <Grid container spacing={2}>
            <Grid item xs={6}>
              <Box className={classes.leftSection}>
                <Typography variant="h3" className={classes.welcomeText}>
                  Virtual Smart Classroom
                </Typography>
                <img src={logo} alt="Illustration" className={classes.logo} />
              </Box>
            </Grid>

            <Grid item xs={4}>
            <Box className={classes.rightSection}>
              <Box className={classes.loginForm}>
                <Typography variant="h4" gutterBottom>
                  Sign in to Class
                </Typography>
                <Box bgcolor="#e7f3ff" p={2} borderRadius={4} color="#3178c6" mb={2}>
                New user? <a href=''>Create an account</a> 
                </Box>
                <TextField
                  variant="outlined"
                  margin="normal"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                  required
                  fullWidth
                  label="Email Address"
                  autoComplete="email"
                  autoFocus
                />
                <TextField
                  variant="outlined"
                  margin="normal"
                  required
                  fullWidth
                  label="Password"
                  type="password"
                  autoComplete="current-password"
                />
                <Button  type="submit" fullWidth variant="contained" color="primary">
                  Login
                </Button>
                <Box mt={2}>
                  <Button href="#" variant="text" color="primary">
                    Forgot password?
                  </Button>
                </Box>
              </Box>
            </Box>
            <Box><UserList/></Box>
            </Grid>
          </Grid>
        </Container>
      </div>
    </ThemeProvider>
  );
}

export default LoginPage;
