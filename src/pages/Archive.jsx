import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

function Archive() {
    const navigate = useNavigate();

    const [archivedNotes, setArchivedNotes] = useState([]);
    const [message, setMessage] = useState("");

    const fetchArchivedNotes = async () => {
        try {
            const response = await api.get("/api/notes/archived");
            setArchivedNotes(response.data);
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to load archived notes."
            );
        }
    };

    useEffect(() => {
        fetchArchivedNotes();
    }, []);

    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("message");
        navigate("/login");
    };

    const handleUnarchiveNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/archive`);
            setMessage("Note unarchived successfully.");
            await fetchArchivedNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to unarchive note."
            );
        }
    };

    const handleTrashNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/trash`);
            setMessage("Note moved to trash.");
            await fetchArchivedNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to move note to trash."
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

                    <button type="button" className="sidebar-link active">
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
                        <h1>Archive</h1>
                        <p>View and manage archived notes</p>
                    </div>

                    <button type="button" className="logout-btn" onClick={handleLogout}>
                        Logout
                    </button>
                </header>

                {message && <div className="dashboard-message">{message}</div>}

                <section className="notes-grid">
                    {archivedNotes.length === 0 ? (
                        <div className="empty-state">No archived notes found.</div>
                    ) : (
                        archivedNotes.map((note) => (
                            <div className="note-card" key={note.id}>
                                <h3>{note.title}</h3>
                                <p>{note.description}</p>

                                <div className="note-meta">
                                    <span>Archived</span>
                                    {note.reminderAt && <span> Reminder: {note.reminderAt}</span>}
                                </div>

                                <div className="note-actions">
                                    <button
                                        type="button"
                                        onClick={() => handleUnarchiveNote(note.id)}
                                    >
                                        Unarchive
                                    </button>

                                    <button type="button" onClick={() => handleTrashNote(note.id)}>
                                        Trash
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

export default Archive;