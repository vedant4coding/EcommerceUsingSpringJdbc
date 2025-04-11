// BuyerDashboard.js
import React from 'react';

const BuyerDashboard = () => {
  return (
    <div className="container my-5">
      <div className="text-center mb-4">
        <h2 className="fw-bold text-success">Buyer Dashboard</h2>
        <p className="text-muted">Welcome! Shop and manage your orders easily.</p>
      </div>

      <div className="row g-4">
        <div className="col-md-4">
          <div className="card shadow-sm h-100">
            <div className="card-body" style={{ backgroundColor: '#93d2aa' }}>
              <h5 className="card-title">My Orders</h5>
              <p className="card-text">Track and manage your orders</p>
              <button className="btn btn-outline-success w-100">View Orders</button>
            </div>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow-sm h-100">
            <div className="card-body" style={{ backgroundColor: '#93c2d2' }}>
              <h5 className="card-title">Wishlist</h5>
              <p className="card-text">View and update your saved products</p>
              <button className="btn btn-outline-primary w-100">Go to Wishlist</button>
            </div>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow-sm h-100">
            <div className="card-body" style={{ backgroundColor: '#d2c793' }}>
              <h5 className="card-title">Profile</h5>
              <p className="card-text">Edit your profile and shipping info</p>
              <button className="btn btn-outline-warning w-100">Edit Profile</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default BuyerDashboard;
