import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";
import Sidebar from "../components/Sidebar";
import Topnav from "../components/Topnav";

function Trash() {
    const navigate = useNavigate();
    const [trashedNotes, setTrashedNotes] = useState([]);
    const [message, setMessage] = useState("");

    const fetchTrashedNotes = async () => {
        try {
            const response = await api.get("/api/notes/trash");
            setTrashedNotes(response.data);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to load trashed notes.");
        }
    };

    useEffect(() => { fetchTrashedNotes(); }, []);

    const handleRestoreNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/restore`);
            setMessage("Note restored.");
            await fetchTrashedNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to restore note.");
        }
    };

    const handleDeleteNote = async (noteId) => {
        if (!window.confirm("Permanently delete this note?")) return;
        try {
            await api.delete(`/api/notes/${noteId}`);
            setMessage("Note deleted.");
            await fetchTrashedNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to delete note.");
        }
    };

    return (
        <div className="app-layout">
            <Topnav title="Trash" />
            <Sidebar active="trash" />
            <main className="main-content">
                {message && <div className="dashboard-message" onClick={() => setMessage("")} style={{ cursor: "pointer" }}>{message}</div>}

                <div style={{ maxWidth: "800px", margin: "0 auto 16px", background: "#fef7e0", border: "1px solid #fbbc04", borderRadius: "8px", padding: "12px 16px", fontSize: "14px", color: "#5f4b00" }}>
                    <i className="ti ti-info-circle" style={{ marginRight: "6px" }}></i>
                    Notes in Trash will be deleted after 7 days
                </div>

                {trashedNotes.length === 0 ? (
                    <div className="notes-grid">
                        <div className="empty-state">
                            <i className="ti ti-trash"></i>
                            <p>No notes in Trash</p>
                        </div>
                    </div>
                ) : (
                    <>
                        <p className="notes-section-title">Trash</p>
                        <div className="notes-grid">
                            {trashedNotes.map(note => (
                                <div className="note-card" key={note.id} style={{ opacity: 0.8 }}>
                                    {note.title && <h3>{note.title}</h3>}
                                    <p>{note.description}</p>
                                    <div className="note-hover-actions" style={{ display: "flex" }}>
                                        <button type="button" className="note-action-btn" onClick={() => handleRestoreNote(note.id)} title="Restore">
                                            <i className="ti ti-restore"></i>
                                        </button>
                                        <button type="button" className="note-action-btn danger" onClick={() => handleDeleteNote(note.id)} title="Delete permanently">
                                            <i className="ti ti-trash-x"></i>
                                        </button>
                                    </div>
                                </div>
                            ))}
                        </div>
                    </>
                )}
            </main>
        </div>
    );
}

export default Trash;
