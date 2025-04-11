import { useState } from 'react'; // Import useState
import { logins } from '../API/Auth'; // your backend login API
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [username, setUsername] = useState(''); // State for username
  const [password, setPassword] = useState(''); // State for password
  const [error, setError] = useState(''); // State for error messages
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    if (!username || !password) {
      setError('Please fill in all fields');
      return;
    }

    try {
      const response = await logins({ username, password});
      const role = response.data.trim();

      console.log('Role:', role);
      setError('');
      alert('Login successful! Redirecting...');

      // Redirect based on role
      if (role === 'redirect:/admin/dashboard') {
        navigate('/admin');
      } else if (role === 'redirect:/buyer/dashboard') {
        navigate('/Buyer');
      } else if (role === 'redirect:/seller/dashboard') {
        navigate('/Seller');
      } else {
        setError('Unknown user role');
      }
    } catch (err) {
      console.error(err);
      setError('Invalid username or password');
    }
  };

  return (
    <div className="container mt-5" style={{ maxWidth: '500px' }}>
      <div className="card shadow bg-light">
        <div className="card-body" style={{ background:'linear-gradient(#D16BA5,#86A8E7,#5FFBF1)' }}>
          <h2 className="text-center mb-4">Login</h2>

          {error && <div className="alert alert-danger">{error}</div>} {/* Display error */}

          <form onSubmit={handleLogin}>
            <div className="mb-3">
              <label className="form-label">Username</label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </div>

            <div className="mb-3">
              <label className="form-label">Password</label>
              <input
                type="password"
                className="form-control"
                placeholder="Enter password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>

            <button type="submit" className="btn w-100" style={{ backgroundColor: '#C3E0E5' }}>Login</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;