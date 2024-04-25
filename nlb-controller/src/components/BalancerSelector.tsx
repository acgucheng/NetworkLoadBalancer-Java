/* A mui selector to select balancer between round-robin and random algorithms */
import React from 'react';
import { FormControl, InputLabel, Select, MenuItem } from '@mui/material';

interface BalancerSelectorProps {
  balancer: string;
  setBalancer: (balancer: string) => void;
  style?: React.CSSProperties;
}

export const BalancerSelector: React.FC<BalancerSelectorProps> = ({ balancer, setBalancer, style }) => {
  return (
    <FormControl style={{minWidth:"100%"}}>
      <InputLabel id="balancer-label">Balancer</InputLabel>
      <Select
        labelId="balancer-label"
        id="balancer"
        value={balancer}
        style={{ width: "50%"}}
        onChange={(e) => setBalancer(e.target.value as string)}
      >
        <MenuItem value={"RoundRobin"}>Round Robin</MenuItem>
        <MenuItem value={"Random"}>Random</MenuItem>
      </Select>
    </FormControl>
  );
};