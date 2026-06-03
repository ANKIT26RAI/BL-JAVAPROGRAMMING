import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";
import Sidebar from "../components/Sidebar";
import Topnav from "../components/Topnav";

function Export() {
    const navigate = useNavigate();
    const [message, setMessage] = useState("");
    const [loading, setLoading] = useState(false);

    const handleExportExcel = async () => {
        setMessage("");
        setLoading(true);
        try {
            const response = await api.get("/api/export/notes/excel", { responseType: "blob" });
            const fileBlob = new Blob([response.data], { type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" });
            const downloadUrl = window.URL.createObjectURL(fileBlob);
            const link = document.createElement("a");
            link.href = downloadUrl;
            link.download = "fundoo-notes.xlsx";
            document.body.appendChild(link);
            link.click();
            link.remove();
            window.URL.revokeObjectURL(downloadUrl);
            setMessage("Notes exported successfully.");
        } catch (error) {
            if (error.response?.status === 403) {
                setMessage("Export is available only for premium users.");
            } else {
                setMessage(error.response?.data?.message || "Failed to export notes.");
            }
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="app-layout">
            <Topnav title="Export" />
            <Sidebar active="export" />
            <main className="main-content">
                {message && <div className="dashboard-message" onClick={() => setMessage("")} style={{ cursor: "pointer" }}>{message}</div>}

                <div className="export-card">
                    <div style={{ display: "flex", alignItems: "center", gap: "12px", marginBottom: "16px" }}>
                        <div style={{ width: "48px", height: "48px", background: "#e8f0fe", borderRadius: "12px", display: "flex", alignItems: "center", justifyContent: "center" }}>
                            <i className="ti ti-file-spreadsheet" style={{ fontSize: "24px", color: "#1a73e8" }}></i>
                        </div>
                        <h2>Export to Excel</h2>
                    </div>
                    <p>Download all your active notes as an Excel spreadsheet. Useful for backup, sharing, and offline access.</p>
                    <button type="button" className="primary-small-btn export-btn" onClick={handleExportExcel} disabled={loading}>
                        <i className="ti ti-download" style={{ marginRight: "6px" }}></i>
                        {loading ? "Exporting..." : "Download Excel"}
                    </button>
                </div>
            </main>
        </div>
    );
}

export default Export;
