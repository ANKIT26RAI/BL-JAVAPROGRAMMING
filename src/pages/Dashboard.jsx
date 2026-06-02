import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

function Dashboard() {
    const navigate = useNavigate();

    const [notes, setNotes] = useState([]);
    const [labels, setLabels] = useState([]);

    const [noteForm, setNoteForm] = useState({
        title: "",
        description: "",
        reminderAt: "",
    });

    const [editingNoteId, setEditingNoteId] = useState(null);

    const [editForm, setEditForm] = useState({
        title: "",
        description: "",
        reminderAt: "",
    });

    const [selectedLabels, setSelectedLabels] = useState({});
    const [searchKeyword, setSearchKeyword] = useState("");
    const [isSearching, setIsSearching] = useState(false);

    const [message, setMessage] = useState("");
    const [loading, setLoading] = useState(false);

    const fetchNotes = async () => {
        try {
            const response = await api.get("/api/notes");
            setNotes(response.data);
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to load notes."
            );
        }
    };

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
        fetchNotes();
        fetchLabels();
    }, []);

    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("message");
        navigate("/login");
    };

    const handleChange = (e) => {
        setNoteForm({
            ...noteForm,
            [e.target.name]: e.target.value,
        });
    };

    const handleEditChange = (e) => {
        setEditForm({
            ...editForm,
            [e.target.name]: e.target.value,
        });
    };

    const handleCreateNote = async (e) => {
        e.preventDefault();
        setMessage("");
        setLoading(true);

        try {
            const payload = {
                title: noteForm.title.trim(),
                description: noteForm.description.trim(),
                reminderAt: noteForm.reminderAt ? noteForm.reminderAt : null,
            };

            await api.post("/api/notes", payload);

            setNoteForm({
                title: "",
                description: "",
                reminderAt: "",
            });

            setMessage("Note created successfully.");
            await fetchNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to create note."
            );
        } finally {
            setLoading(false);
        }
    };

    const handlePinNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/pin`);
            setMessage("Note pin status updated.");
            await fetchNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to pin/unpin note."
            );
        }
    };

    const handleArchiveNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/archive`);
            setMessage("Note archive status updated.");
            await fetchNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to archive/unarchive note."
            );
        }
    };

    const handleTrashNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/trash`);
            setMessage("Note moved to trash.");
            await fetchNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to move note to trash."
            );
        }
    };

    const startEditNote = (note) => {
        setEditingNoteId(note.id);

        setEditForm({
            title: note.title || "",
            description: note.description || "",
            reminderAt: note.reminderAt ? note.reminderAt.slice(0, 16) : "",
        });

        setMessage("");
    };

    const cancelEditNote = () => {
        setEditingNoteId(null);

        setEditForm({
            title: "",
            description: "",
            reminderAt: "",
        });
    };

    const handleUpdateNote = async (noteId) => {
        setMessage("");

        try {
            const payload = {
                title: editForm.title.trim(),
                description: editForm.description.trim(),
                reminderAt: editForm.reminderAt ? editForm.reminderAt : null,
            };

            await api.put(`/api/notes/${noteId}`, payload);

            setMessage("Note updated successfully.");
            setEditingNoteId(null);

            setEditForm({
                title: "",
                description: "",
                reminderAt: "",
            });

            await fetchNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to update note."
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
            await fetchNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to delete note."
            );
        }
    };

    const handleLabelSelect = (noteId, labelId) => {
        setSelectedLabels({
            ...selectedLabels,
            [noteId]: labelId,
        });
    };

    const handleAddLabelToNote = async (noteId) => {
        const labelId = selectedLabels[noteId];

        if (!labelId) {
            setMessage("Please select a label first.");
            return;
        }

        try {
            await api.put(`/api/labels/${labelId}/notes/${noteId}`);
            setMessage("Label added to note successfully.");
            await fetchNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to add label to note."
            );
        }
    };

    const handleRemoveLabelFromNote = async (noteId, labelId) => {
        try {
            await api.delete(`/api/labels/${labelId}/notes/${noteId}`);
            setMessage("Label removed from note successfully.");
            await fetchNotes();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to remove label from note."
            );
        }
    };

    const handleSearchNotes = async (e) => {
        e.preventDefault();

        if (!searchKeyword.trim()) {
            setMessage("Please enter something to search.");
            return;
        }

        try {
            const response = await api.get(
                `/api/notes/search?keyword=${encodeURIComponent(searchKeyword.trim())}`
            );

            setNotes(response.data);
            setIsSearching(true);
            setMessage(`Search results for "${searchKeyword.trim()}"`);
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to search notes."
            );
        }
    };

    const handleClearSearch = async () => {
        setSearchKeyword("");
        setIsSearching(false);
        setMessage("");
        await fetchNotes();
    };

    return (
        <div className="app-layout">
            <aside className="sidebar">
                <h2>Fundoo</h2>

                <nav>
                    <button type="button" className="sidebar-link active">
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
                        <h1>Notes</h1>
                        <p>Manage your Fundoo Notes</p>
                    </div>

                    <form className="search-form" onSubmit={handleSearchNotes}>
                        <input
                            type="text"
                            placeholder="Search notes..."
                            value={searchKeyword}
                            onChange={(e) => setSearchKeyword(e.target.value)}
                        />

                        <button type="submit">Search</button>

                        {isSearching && (
                            <button type="button" onClick={handleClearSearch}>
                                Clear
                            </button>
                        )}
                    </form>

                    <button type="button" className="logout-btn" onClick={handleLogout}>
                        Logout
                    </button>
                </header>

                {message && <div className="dashboard-message">{message}</div>}

                <form className="create-note-card" onSubmit={handleCreateNote}>
                    <input
                        type="text"
                        name="title"
                        placeholder="Title"
                        value={noteForm.title}
                        onChange={handleChange}
                        required
                    />

                    <textarea
                        name="description"
                        placeholder="Take a note..."
                        rows="3"
                        value={noteForm.description}
                        onChange={handleChange}
                        required
                    ></textarea>

                    <div className="create-note-actions">
                        <input
                            type="datetime-local"
                            name="reminderAt"
                            value={noteForm.reminderAt}
                            onChange={handleChange}
                        />

                        <button className="primary-small-btn" type="submit" disabled={loading}>
                            {loading ? "Creating..." : "Create Note"}
                        </button>
                    </div>
                </form>

                <section className="notes-grid">
                    {notes.length === 0 ? (
                        <div className="empty-state">No notes found.</div>
                    ) : (
                        notes.map((note) => (
                            <div className="note-card" key={note.id}>
                                {editingNoteId === note.id ? (
                                    <>
                                        <input
                                            className="edit-input"
                                            type="text"
                                            name="title"
                                            value={editForm.title}
                                            onChange={handleEditChange}
                                            placeholder="Title"
                                        />

                                        <textarea
                                            className="edit-textarea"
                                            name="description"
                                            value={editForm.description}
                                            onChange={handleEditChange}
                                            placeholder="Description"
                                            rows="4"
                                        ></textarea>

                                        <input
                                            className="edit-input"
                                            type="datetime-local"
                                            name="reminderAt"
                                            value={editForm.reminderAt}
                                            onChange={handleEditChange}
                                        />

                                        <div className="note-actions">
                                            <button
                                                type="button"
                                                onClick={() => handleUpdateNote(note.id)}
                                            >
                                                Save
                                            </button>

                                            <button type="button" onClick={cancelEditNote}>
                                                Cancel
                                            </button>
                                        </div>
                                    </>
                                ) : (
                                    <>
                                        <h3>{note.title}</h3>
                                        <p>{note.description}</p>

                                        <div className="note-meta">
                                            {note.pinned && <span>Pinned </span>}
                                            {note.archived && <span>Archived </span>}
                                            {note.reminderAt && <span>Reminder: {note.reminderAt}</span>}
                                        </div>

                                        {note.labels && note.labels.length > 0 && (
                                            <div className="note-labels">
                                                {note.labels.map((label) => (
                                                    <span className="note-label-chip" key={label.id}>
                            {label.name}
                                                        <button
                                                            type="button"
                                                            onClick={() =>
                                                                handleRemoveLabelFromNote(note.id, label.id)
                                                            }
                                                        >
                              ×
                            </button>
                          </span>
                                                ))}
                                            </div>
                                        )}

                                        <div className="label-assign-row">
                                            <select
                                                value={selectedLabels[note.id] || ""}
                                                onChange={(e) =>
                                                    handleLabelSelect(note.id, e.target.value)
                                                }
                                            >
                                                <option value="">Select label</option>

                                                {labels.map((label) => (
                                                    <option key={label.id} value={label.id}>
                                                        {label.name}
                                                    </option>
                                                ))}
                                            </select>

                                            <button
                                                type="button"
                                                onClick={() => handleAddLabelToNote(note.id)}
                                            >
                                                Add
                                            </button>
                                        </div>

                                        <div className="note-actions">
                                            <button type="button" onClick={() => handlePinNote(note.id)}>
                                                {note.pinned ? "Unpin" : "Pin"}
                                            </button>

                                            <button
                                                type="button"
                                                onClick={() => handleArchiveNote(note.id)}
                                            >
                                                {note.archived ? "Unarchive" : "Archive"}
                                            </button>

                                            <button type="button" onClick={() => handleTrashNote(note.id)}>
                                                Trash
                                            </button>

                                            <button type="button" onClick={() => startEditNote(note)}>
                                                Edit
                                            </button>

                                            <button
                                                type="button"
                                                className="danger-btn"
                                                onClick={() => handleDeleteNote(note.id)}
                                            >
                                                Delete
                                            </button>
                                        </div>
                                    </>
                                )}
                            </div>
                        ))
                    )}
                </section>
            </main>
        </div>
    );
}

export default Dashboard;