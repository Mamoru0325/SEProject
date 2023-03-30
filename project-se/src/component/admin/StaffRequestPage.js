import React from 'react'
import { DataGrid } from '@mui/x-data-grid'
import {} from './StaffRequestPage.css'

const RequestColumns = [
  { field: 'id', headerName: 'ID', width: 70 },
  { field: 'UserName', headerName: 'User Name', width: 180 },
  { field: 'Detail', headerName: 'DetailDesc', width: 700 },
  {
    field: 'Approve',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 160,
    renderCell:(cellValues)=>{
      return(
        <div className='lll'>
            <button type="button" className='ApproveButt' style={{background:'#ace1af'}}>Approve</button>
        </div>
      )
    },
    // valueGetter: (params) =>
    //   `${params.row.firstName || ''} ${params.row.lastName || ''}`,
  },
  {
    field: 'Reject',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 160,
    renderCell:(cellValues)=>{
      return(
        <div className='lll'>
            <button type="button" className='ApproveButt' style={{background:'#e67877 '}}>Reject</button>
        </div>
        
      )
    }
  },
];

const RequestRows = [
  { id: 1, UserName: 'ReportSnow', DetailDes: 'Jon' },
  { id: 2, UserName: 'Lannister', DetailDes: 'Cersei' },
  { id: 3, UserName: 'Lannister', DetailDes: 'Jaime' },
];

const RequestTable=()=> {
  return (
    <div style={{ height: 550, width: '100%' }}>
      <DataGrid
        rows={RequestRows}
        columns={RequestColumns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      />
    </div>
  );
}

const StaffRequestPage = () => {
  return (
    <div className='AdminManagementPage-Con'>
      <div className='AdminManagement-Con'>
        <div className='AdminManagementTable-con'>
          <div className='AdminManagementTableHead-con'>
            <RequestTable/>
          </div>
        </div>
      </div>
    </div>
  )
}

export default StaffRequestPage