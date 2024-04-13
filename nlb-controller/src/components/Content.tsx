/* This is a content react component */
import React from 'react';
import { Typography } from '@mui/material';
import '../css/Content.css'
import {HostManagementPage} from "./HostManagementPage";
export class Content extends React.Component {
    render() {
        return (
            <div className="Content" style={{flexDirection: "column"}}>
                <Typography variant="h4" style={{marginTop: 10, marginBottom: 10}}>Host Management</Typography>
                <HostManagementPage />
            </div>
        );
    }
}