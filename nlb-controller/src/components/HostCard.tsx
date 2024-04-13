/* This is a class component card using mui to
display the host information including ip, port, health status, and a button to delete it */
import React from 'react';
import { Card, CardContent, Typography, Button } from '@mui/material';
import { Host } from '../model/Host';
import { deleteHost } from '../api/hosts';

export class HostCard extends React.Component<{host: Host}> {
    render() {
        return (
            <Card style={{margin:10}}>
                <CardContent>
                    <Typography variant="h5">
                        {this.props.host.ip}:{this.props.host.port}
                    </Typography>
                    <Typography variant="body2">
                        {this.props.host.health}
                    </Typography>
                    <Button onClick={() => deleteHost(this.props.host.ip, this.props.host.port)}>Delete</Button>
                </CardContent>
            </Card>
        );
    }
}




