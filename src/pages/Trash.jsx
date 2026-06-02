import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

function Trash() {
    const navigate = useNavigate();

    const [trashedNotes, setTrashedNotes] = useState([]);
    const [message, setMessage] = useState("");

    const fetchTrashedNotes = async () => {
        try {
            const response = await api.get("/api/notes/trash");
            setTrashedNotes(response.data);
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to load trashed notes."
            );
        }
    };

    useEffect(() => {
        fetchTrashedNotes();
    }, []);

    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("message");
        navigate("/login");
    };

    const handleRestoreNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/restore`);
            setMessage("Note restored successfully.");
            await fetchTrashedNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to restore note."
            );
        }
    };

    const handleDeleteNote = async (noteId) => {
        const confirmDelete = window.confirm(
            "Are you sure you want to permanently delete this note?"
        );

        if (!confirmDelete) {
            return;
        }

        try {
            await api.delete(`/api/notes/${noteId}`);
            setMessage("Note permanently deleted.");
            await fetchTrashedNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to delete note."
            );
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

                    <button type="button" className="sidebar-link active">
                        Trash
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/labels")}
                    >
                        Labels
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/export")}
                    >
                        Export
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/payments")}
                    >
                        Payments
                    </button>
                </nav>
            </aside>

            <main className="main-content">
                <header className="topbar">
                    <div>
                        <h1>Trash</h1>
                        <p>Restore or permanently delete your notes</p>
                    </div>

                    <button type="button" className="logout-btn" onClick={handleLogout}>
                        Logout
                    </button>
                </header>

                {message && <div className="dashboard-message">{message}</div>}

                <section className="notes-grid">
                    {trashedNotes.length === 0 ? (
                        <div className="empty-state">No trashed notes found.</div>
                    ) : (
                        trashedNotes.map((note) => (
                            <div className="note-card" key={note.id}>
                                <h3>{note.title}</h3>
                                <p>{note.description}</p>

                                <div className="note-meta">
                                    <span>Trashed</span>
                                    {note.reminderAt && <span> Reminder: {note.reminderAt}</span>}
                                </div>

                                <div className="note-actions">
                                    <button
                                        type="button"
                                        onClick={() => handleRestoreNote(note.id)}
                                    >
                                        Restore
                                    </button>

                                    <button
                                        type="button"
                                        className="danger-btn"
                                        onClick={() => handleDeleteNote(note.id)}
                                    >
                                        Delete
                                    </button>
                                </div>
                            </div>
                        ))
                    )}
                </section>
            </main>
        </div>
    );
}

export default Trash;