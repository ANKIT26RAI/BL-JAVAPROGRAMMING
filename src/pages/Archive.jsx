import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";
import Sidebar from "../components/Sidebar";
import Topnav from "../components/Topnav";

function Archive() {
    const navigate = useNavigate();
    const [archivedNotes, setArchivedNotes] = useState([]);
    const [message, setMessage] = useState("");

    const fetchArchivedNotes = async () => {
        try {
            const response = await api.get("/api/notes/archived");
            setArchivedNotes(response.data);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to load archived notes.");
        }
    };

    useEffect(() => { fetchArchivedNotes(); }, []);

    const handleUnarchiveNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/archive`);
            setMessage("Note unarchived.");
            await fetchArchivedNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to unarchive note.");
        }
    };

    const handleTrashNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/trash`);
            setMessage("Note moved to trash.");
            await fetchArchivedNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to trash note.");
        }
    };

    const formatReminder = (dateStr) => {
        if (!dateStr) return null;
        const d = new Date(dateStr);
        return d.toLocaleString("en-IN", { month: "short", day: "numeric", hour: "2-digit", minute: "2-digit" });
    };

    return (
        <div className="app-layout">
            <Topnav title="Archive" />
            <Sidebar active="archive" />
            <main className="main-content">
                {message && <div className="dashboard-message" onClick={() => setMessage("")} style={{ cursor: "pointer" }}>{message}</div>}

                {archivedNotes.length === 0 ? (
                    <div className="notes-grid">
                        <div className="empty-state">
                            <i className="ti ti-archive"></i>
                            <p>Your archived notes appear here</p>
                        </div>
                    </div>
                ) : (
                    <>
                        <p className="notes-section-title">Archived</p>
                        <div className="notes-grid">
                            {archivedNotes.map(note => (
                                <div className="note-card" key={note.id}>
                                    {note.title && <h3>{note.title}</h3>}
                                    <p>{note.description}</p>
                                    {note.reminderAt && (
                                        <div className="note-reminder">
                                            <i className="ti ti-bell"></i>
                                            {formatReminder(note.reminderAt)}
                                        </div>
                                    )}
                                    <div className="note-hover-actions" style={{ display: "flex" }}>
                                        <button type="button" className="note-action-btn" onClick={() => handleUnarchiveNote(note.id)} title="Unarchive">
                                            <i className="ti ti-archive-off"></i>
                                        </button>
                                        <button type="button" className="note-action-btn" onClick={() => handleTrashNote(note.id)} title="Move to trash">
                                            <i className="ti ti-trash"></i>
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

export default Archive;
