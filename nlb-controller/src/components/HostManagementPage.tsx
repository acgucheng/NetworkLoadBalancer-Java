/* This is react class based host management page component */
import React from 'react';
import { Host } from '../model/Host';
import { HostCard } from './HostCard';
import {addHost, getHosts} from '../api/hosts';
import {Button, TextField} from '@mui/material';

interface HostManagementPageState {
    hosts: Host[];
    hostIp: string;
    port: string;
}
export class HostManagementPage extends React.Component<{},  HostManagementPageState> {
    constructor(props: any) {
        super(props);
        this.state = {
            hosts: [],
            hostIp: '',
            port: ''
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

    refresh(){
        getHosts().then((hosts) => {
            this.setHosts(hosts)
        })
    }

    addHost() {
        // Add a new host
        let newHost = new Host(this.state.hostIp, this.state.port, 'healthy')
        addHost(newHost).then(() => {
            this.refresh()
        })
    }

    render() {
        return (
            <div>
                <div style={{display: "flex" }}>
                    <TextField type="text" variant="outlined"  placeholder="ip" value={this.state.hostIp} style={{margin:10}} onChange={(event) => this.setState({hostIp: event.target.value})}/>
                    <TextField type="text" variant="outlined"  placeholder="port" value={this.state.port} style={{margin:10}} onChange={(event) => this.setState({port:event.target.value})}/>
                    <Button variant="contained" color="primary" onClick={() => this.addHost()}>Add</Button>
                </div>
                <div style={{display: "flex"}}>
                    {this.state.hosts.map((host: Host) => (
                        <HostCard host={host} onDelete={() => this.refresh()} />
                    ))}
                </div>
            </div>
        );
    }
}