import React, { useEffect, useState } from 'react';
import { addProduct } from '../API/Auth';

const Product = () => {
  const [formData, setFormData] = useState({
    prodname: '',
    proddesc: '',
    price: '',
    discount: '',
    quantity: '',
    categoryname: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Form submitted:', formData);
  
    addProduct(formData)
      .then(() => {
        alert('Product added successfully!');
        setFormData({
          prodname: '',
          proddesc: '',
          price: '',
          discount: '',
          quantity: '',
          categoryname: '',
        });
      })
      .catch((error) => {
        console.error('Error adding product:', error);
        alert('Failed to add product');
      });
  };
  
  return (
    <div className="container mt-4">
      <h3 className="mb-4 text-center">Add New Product</h3>
      <form onSubmit={handleSubmit} className="shadow p-4 rounded bg-light">
        <div className="mb-3">
          <label className="form-label">Product Name</label>
          <input
            type="text"
            className="form-control"
            name="prodname"
            value={formData.prodname}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Product Description</label>
          <input
            type="text"
            className="form-control"
            name="proddesc"
            value={formData.proddesc}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Price</label>
          <input
            type="number"
            className="form-control"
            name="price"
            value={formData.price}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Discount (%)</label>
          <input
            type="number"
            className="form-control"
            name="discount"
            value={formData.discount}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Quantity</label>
          <input
            type="number"
            className="form-control"
            name="quantity"
            value={formData.quantity}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-4">
          <label className="form-label">Category</label>
          <select
            className="form-select"
            name="categoryname"
            value={formData.categoryname}
            onChange={handleChange}
            required
          >
            <option value="">Select Category</option>
            <option value="Electronics">Electronics</option>
            <option value="Books">Books</option>
            <option value="Fashion">Fashion</option>
            <option value="Mobiles">Mobiles</option>
            <option value="Laptops">Laptops</option>
          </select>
        </div>

        <button type="submit" className="btn btn-primary w-100">
          Add Product
        </button>
      </form>
    </div>
  );
};

export default Product;
