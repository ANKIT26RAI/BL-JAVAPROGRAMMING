import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";
import Sidebar from "../components/Sidebar";
import Topnav from "../components/Topnav";

function Labels() {
    const navigate = useNavigate();
    const [labels, setLabels] = useState([]);
    const [labelName, setLabelName] = useState("");
    const [selectedLabel, setSelectedLabel] = useState(null);
    const [labelNotes, setLabelNotes] = useState([]);
    const [message, setMessage] = useState("");
    const [loading, setLoading] = useState(false);

    const fetchLabels = async () => {
        try {
            const response = await api.get("/api/labels");
            setLabels(response.data);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to load labels.");
        }
    };

    useEffect(() => { fetchLabels(); }, []);

    const handleCreateLabel = async (e) => {
        e.preventDefault();
        setLoading(true);
        try {
            await api.post("/api/labels", { name: labelName.trim() });
            setLabelName("");
            setMessage("Label created.");
            await fetchLabels();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to create label.");
        } finally {
            setLoading(false);
        }
    };

    const handleDeleteLabel = async (labelId) => {
        if (!window.confirm("Delete this label?")) return;
        try {
            await api.delete(`/api/labels/${labelId}`);
            setMessage("Label deleted.");
            if (selectedLabel?.id === labelId) { setSelectedLabel(null); setLabelNotes([]); }
            await fetchLabels();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to delete label.");
        }
    };

    const handleViewNotesByLabel = async (label) => {
        setSelectedLabel(label);
        try {
            const response = await api.get(`/api/labels/${label.id}/notes`);
            setLabelNotes(response.data);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to load notes.");
        }
    };

    return (
        <div className="app-layout">
            <Topnav title="Labels" />
            <Sidebar active="labels" />
            <main className="main-content">
                {message && <div className="dashboard-message" onClick={() => setMessage("")} style={{ cursor: "pointer" }}>{message}</div>}

                <section className="labels-layout">
                    <div className="labels-panel">
                        <h2 style={{ fontSize: "16px", fontWeight: "500", marginBottom: "16px", color: "#202124" }}>Labels</h2>
                        <form className="label-form" onSubmit={handleCreateLabel}>
                            <input type="text" placeholder="New label name" value={labelName} onChange={(e) => setLabelName(e.target.value)} required />
                            <button type="submit" className="primary-small-btn" disabled={loading}>
                                {loading ? "..." : <i className="ti ti-plus"></i>}
                            </button>
                        </form>

                        <div className="labels-list">
                            {labels.length === 0 ? (
                                <p style={{ color: "#5f6368", fontSize: "14px", padding: "8px" }}>No labels yet</p>
                            ) : (
                                labels.map(label => (
                                    <div className={`label-item ${selectedLabel?.id === label.id ? "selected-label" : ""}`} key={label.id}>
                                        <i className="ti ti-tag" style={{ fontSize: "16px", color: "#5f6368" }} aria-hidden="true"></i>
                                        <button type="button" onClick={() => handleViewNotesByLabel(label)}>
                                            {label.name}
                                        </button>
                                        <button type="button" className="label-delete-btn" onClick={() => handleDeleteLabel(label.id)}>
                                            <i className="ti ti-trash" style={{ fontSize: "16px" }}></i>
                                        </button>
                                    </div>
                                ))
                            )}
                        </div>
                    </div>

                    <div className="label-notes-panel">
                        <h2 style={{ fontSize: "16px", fontWeight: "500", marginBottom: "16px" }}>
                            {selectedLabel ? `"${selectedLabel.name}" notes` : "Select a label"}
                        </h2>

                        <section className="notes-grid">
                            {!selectedLabel ? (
                                <div className="empty-state">
                                    <i className="ti ti-tag"></i>
                                    <p>Select a label to view notes</p>
                                </div>
                            ) : labelNotes.length === 0 ? (
                                <div className="empty-state">
                                    <i className="ti ti-notes-off"></i>
                                    <p>No notes with this label</p>
                                </div>
                            ) : (
                                labelNotes.map(note => (
                                    <div className="note-card" key={note.id}>
                                        {note.title && <h3>{note.title}</h3>}
                                        <p>{note.description}</p>
                                        {note.pinned && <span className="note-label-chip" style={{ marginTop: "8px" }}>📌 Pinned</span>}
                                    </div>
                                ))
                            )}
                        </section>
                    </div>
                </section>
            </main>
        </div>
    );
}

export default Labels;
