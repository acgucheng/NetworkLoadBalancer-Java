/* This is react class based host management page component */
import React from 'react';
import { Host } from '../model/Host';
import { HostCard } from './HostCard';
import { getHosts } from '../api/hosts';
import { Button } from '@mui/material';

interface HostManagementPageState {
    hosts: Host[];
}
export class HostManagementPage extends React.Component<{},  HostManagementPageState> {
    constructor(props: any) {
        super(props);
        this.state = {
            hosts: []
        };
    }

    setHosts(hosts: Host[]) {
        this.setState({hosts: hosts});
    }

    componentDidMount() {
        getHosts().then((hosts) => {
            this.setHosts(hosts);
        });
    }

    render() {
        return (
            <div style={{display: "flex"}}>
                {this.state.hosts.map((host: Host) => (
                    <HostCard host={host} />
                ))}
            </div>
        );
    }
}