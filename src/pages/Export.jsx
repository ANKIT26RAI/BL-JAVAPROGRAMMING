import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

function Export() {
    const navigate = useNavigate();

    const [message, setMessage] = useState("");
    const [loading, setLoading] = useState(false);

    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("message");
        navigate("/login");
    };

    const handleExportExcel = async () => {
        setMessage("");
        setLoading(true);

        try {
            const response = await api.get("/api/export/notes/excel", {
                responseType: "blob",
            });

            const fileBlob = new Blob([response.data], {
                type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            });

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
            console.log(error);

            if (error.response?.status === 403) {
                setMessage("Export is available only for premium users.");
            } else {
                setMessage(
                    error.response?.data?.message ||
                    error.response?.data ||
                    "Failed to export notes."
                );
            }
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="app-layout">
            <aside className="sidebar">
                <h2>Fundoo</h2>

                <nav>
                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/dashboard")}
                    >
                        Notes
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/archive")}
                    >
                        Archive
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/trash")}
                    >
                        Trash
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/labels")}
                    >
                        Labels
                    </button>

                    <button type="button" className="sidebar-link active">
                        Export
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/payments")}
                    >
                        Payments
                    </button>
                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/attachments")}
                    >
                        Attachments
                    </button>
                </nav>
            </aside>

            <main className="main-content">
                <header className="topbar">
                    <div>
                        <h1>Export</h1>
                        <p>Export your notes into Excel format</p>
                    </div>

                    <button type="button" className="logout-btn" onClick={handleLogout}>
                        Logout
                    </button>
                </header>

                {message && <div className="dashboard-message">{message}</div>}

                <section className="export-card">
                    <h2>Export Notes to Excel</h2>

                    <p>
                        Download all your active notes in Excel format. This is useful for
                        backup, reporting, and offline access.
                    </p>

                    <button
                        type="button"
                        className="primary-small-btn export-btn"
                        onClick={handleExportExcel}
                        disabled={loading}
                    >
                        {loading ? "Exporting..." : "Download Excel"}
                    </button>
                </section>
            </main>
        </div>
    );
}

export default Export;