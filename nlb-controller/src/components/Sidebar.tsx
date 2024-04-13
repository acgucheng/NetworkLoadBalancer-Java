/* A Sidebar react class component with MUI */
import React from 'react';
import { Drawer, List, ListItem, ListItemIcon, ListItemText } from '@mui/material';
import '../css/Drawer.css'
import {Settings, Dns} from '@mui/icons-material';
export class Sidebar extends React.Component {
    render() {
        return (
            <Drawer
                variant="permanent"
                sx={{
                    position: 'static',
                    width: 240,
                    flexShrink: 0,
                    '& .MuiDrawer-paper': {
                        width: 260,
                        position: 'fixed',
                        boxSizing: 'border-box',
                        marginTop: 7.5,
                        backgroundColor: '#282c34',
                    },
                    display: 'flex',
                }}
            >
                <List>
                    <ListItem className="DrawerItem">
                        <ListItemIcon>
                            <Dns style={{color:'#ffffff'}}/>
                        </ListItemIcon>
                        <ListItemText primary="Host Management" />
                    </ListItem>
                    <ListItem className="DrawerItem">
                        <ListItemIcon>
                            {/* <DraftsIcon /> */}
                        </ListItemIcon>
                        <ListItemText primary="Statistics" />
                    </ListItem>
                </List>
            </Drawer>
        );
    }
}

