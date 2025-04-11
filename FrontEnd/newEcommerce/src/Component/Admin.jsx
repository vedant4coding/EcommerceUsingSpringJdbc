import React from 'react';

const Admin = () => {
  return (
    <div className="container my-5" >
      <div className="text-center mb-4">
        <h2 className="fw-bold text-primary">Admin Dashboard</h2>
        <p className="text-muted">Welcome to the admin control panel</p>
      </div>

      <div className="row g-4">
        <div className="col-md-4">
          <div className="card shadow-sm h-100">
            <div className="card-body" style={{ maxWidth: '600px', backgroundColor: '#a393d2' }}>
              <h5 className="card-title">Users</h5>
              <p className="card-text">Manage all registered users</p>
              <button className="btn btn-outline-primary w-100">Manage Users</button>
            </div>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow-sm h-100">
            <div className="card-body" style={{ maxWidth: '600px', backgroundColor: '#d293d2' }}>
              <h5 className="card-title">Products</h5>
              <p className="card-text">Add, update or delete products</p>
              <button className="btn btn-outline-success w-100">Manage Products</button>
            </div>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow-sm h-100">
            <div className="card-body"style={{ maxWidth: '600px', backgroundColor: '#d29393' }}>
              <h5 className="card-title">Orders</h5>
              <p className="card-text">View and manage customer orders</p>
              <button className="btn btn-outline-danger w-100">View Orders</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Admin;
