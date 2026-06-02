import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

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
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to load labels."
            );
        }
    };

    useEffect(() => {
        fetchLabels();
    }, []);

    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("message");
        navigate("/login");
    };

    const handleCreateLabel = async (e) => {
        e.preventDefault();
        setMessage("");
        setLoading(true);

        try {
            const payload = {
                name: labelName.trim(),
            };

            await api.post("/api/labels", payload);

            setLabelName("");
            setMessage("Label created successfully.");
            await fetchLabels();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to create label."
            );
        } finally {
            setLoading(false);
        }
    };

    const handleDeleteLabel = async (labelId) => {
        const confirmDelete = window.confirm(
            "Are you sure you want to delete this label?"
        );

        if (!confirmDelete) {
            return;
        }

        try {
            await api.delete(`/api/labels/${labelId}`);
            setMessage("Label deleted successfully.");

            if (selectedLabel?.id === labelId) {
                setSelectedLabel(null);
                setLabelNotes([]);
            }

            await fetchLabels();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to delete label."
            );
        }
    };

    const handleViewNotesByLabel = async (label) => {
        setMessage("");
        setSelectedLabel(label);

        try {
            const response = await api.get(`/api/labels/${label.id}/notes`);
            setLabelNotes(response.data);
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to load notes for this label."
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

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/trash")}
                    >
                        Trash
                    </button>

                    <button type="button" className="sidebar-link active">
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
                        <h1>Labels</h1>
                        <p>Create labels and view notes by category</p>
                    </div>

                    <button type="button" className="logout-btn" onClick={handleLogout}>
                        Logout
                    </button>
                </header>

                {message && <div className="dashboard-message">{message}</div>}

                <section className="labels-layout">
                    <div className="labels-panel">
                        <form className="label-form" onSubmit={handleCreateLabel}>
                            <input
                                type="text"
                                placeholder="Create new label"
                                value={labelName}
                                onChange={(e) => setLabelName(e.target.value)}
                                required
                            />

                            <button type="submit" className="primary-small-btn" disabled={loading}>
                                {loading ? "Creating..." : "Create"}
                            </button>
                        </form>

                        <div className="labels-list">
                            {labels.length === 0 ? (
                                <div className="empty-state small-empty">No labels found.</div>
                            ) : (
                                labels.map((label) => (
                                    <div
                                        className={`label-item ${
                                            selectedLabel?.id === label.id ? "selected-label" : ""
                                        }`}
                                        key={label.id}
                                    >
                                        <button
                                            type="button"
                                            onClick={() => handleViewNotesByLabel(label)}
                                        >
                                            {label.name}
                                        </button>

                                        <button
                                            type="button"
                                            className="label-delete-btn"
                                            onClick={() => handleDeleteLabel(label.id)}
                                        >
                                            Delete
                                        </button>
                                    </div>
                                ))
                            )}
                        </div>
                    </div>

                    <div className="label-notes-panel">
                        <h2>
                            {selectedLabel
                                ? `Notes under "${selectedLabel.name}"`
                                : "Select a label to view notes"}
                        </h2>

                        <section className="notes-grid label-notes-grid">
                            {!selectedLabel ? (
                                <div className="empty-state">Select any label from left side.</div>
                            ) : labelNotes.length === 0 ? (
                                <div className="empty-state">No notes found for this label.</div>
                            ) : (
                                labelNotes.map((note) => (
                                    <div className="note-card" key={note.id}>
                                        <h3>{note.title}</h3>
                                        <p>{note.description}</p>

                                        <div className="note-meta">
                                            {note.pinned && <span>Pinned </span>}
                                            {note.archived && <span>Archived </span>}
                                            {note.reminderAt && <span>Reminder: {note.reminderAt}</span>}
                                        </div>
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