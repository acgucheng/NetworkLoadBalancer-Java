/* This is a content react component */
import React from 'react';
import {Card, Typography} from '@mui/material';
import '../css/Content.css'
import {HostManagementPage} from "./HostManagementPage";
import {BalancerSelector} from "./BalancerSelector";
import {Balancer} from "../api/balancer";

interface ContentPageState {
    balancer: string,
    setBalancer: (balancer: string) => void;
}

export class Content extends React.Component <{}, ContentPageState> {
    constructor(props: any) {
        super(props);
        this.state = {
            balancer: "RoundRobin",
            setBalancer: (balancer : string) => {
                this.setState({balancer: balancer});
                Balancer.setBalancer(balancer).then(() => {
                    alert("Balancer is successfully set to: " + balancer);
                }).catch(
                    (error) => {
                        alert("Failed to set balancer: " + error);
                    }
                )
            }
        }
    }
    render() {
        return (
            <div className="Content" style={{flexDirection: "column"}}>
                <Typography variant="h4" style={{marginTop: 10, marginBottom: 10}}>Host Management</Typography>
                <Card style={{margin:20, padding: 20}}>
                    <BalancerSelector style={{margin: 10, marginBottom: 0}} balancer={this.state.balancer} setBalancer={this.state.setBalancer} />
                </Card>
                <HostManagementPage />
            </div>
        );
    }
}