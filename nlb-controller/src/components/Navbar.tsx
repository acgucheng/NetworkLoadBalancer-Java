/* A Navbar React Class Component with MUI */

import React from 'react';

import { AppBar, Toolbar, Typography, Button } from '@mui/material';

export class Navbar extends React.Component {
    render() {
        return (
            /* fix on the top */
            <AppBar position="fixed" style={{height:60}}>
                <Toolbar>
                    <Typography variant="h6" style={{flexGrow: 1}}>
                        NLB Controller
                    </Typography>
                    <Button color="inherit">Login</Button>
                </Toolbar>
            </AppBar>
        );
    }
}