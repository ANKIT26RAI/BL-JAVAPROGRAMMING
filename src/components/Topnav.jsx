import { useNavigate } from "react-router-dom";

function Topnav({ title }) {
    const navigate = useNavigate();

    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("message");
        navigate("/login");
    };

    return (
        <nav className="topnav">
            <div className="topnav-logo">
                <span>Fundoo<span className="logo-dot"> Notes</span></span>
            </div>
            <div style={{ flex: 1 }} />
            <div className="topnav-actions">
                <span style={{ fontSize: "15px", color: "#5f6368", marginRight: "8px" }}>{title}</span>
                <button className="avatar-btn" onClick={handleLogout} title="Logout">F</button>
            </div>
        </nav>
    );
}

export default Topnav;
