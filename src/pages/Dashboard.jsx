import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

function Dashboard() {
    const navigate = useNavigate();

    const [notes, setNotes] = useState([]);
    const [labels, setLabels] = useState([]);
    const [noteForm, setNoteForm] = useState({ title: "", description: "", reminderAt: "" });
    const [editingNoteId, setEditingNoteId] = useState(null);
    const [editForm, setEditForm] = useState({ title: "", description: "", reminderAt: "" });
    const [selectedLabels, setSelectedLabels] = useState({});
    const [searchKeyword, setSearchKeyword] = useState("");
    const [isSearching, setIsSearching] = useState(false);
    const [message, setMessage] = useState("");
    const [loading, setLoading] = useState(false);
    const [isCreateExpanded, setIsCreateExpanded] = useState(false);

    const fetchNotes = async () => {
        try {
            const response = await api.get("/api/notes");
            setNotes(response.data);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to load notes.");
        }
    };

    const fetchLabels = async () => {
        try {
            const response = await api.get("/api/labels");
            setLabels(response.data);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to load labels.");
        }
    };

    useEffect(() => { fetchNotes(); fetchLabels(); }, []);

    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("message");
        navigate("/login");
    };

    const handleChange = (e) => setNoteForm({ ...noteForm, [e.target.name]: e.target.value });
    const handleEditChange = (e) => setEditForm({ ...editForm, [e.target.name]: e.target.value });

    const handleCreateNote = async (e) => {
        e.preventDefault();
        setMessage("");
        setLoading(true);
        try {
            await api.post("/api/notes", {
                title: noteForm.title.trim(),
                description: noteForm.description.trim(),
                reminderAt: noteForm.reminderAt || null,
            });
            setNoteForm({ title: "", description: "", reminderAt: "" });
            setIsCreateExpanded(false);
            setMessage("Note created.");
            await fetchNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to create note.");
        } finally {
            setLoading(false);
        }
    };

    const handlePinNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/pin`);
            await fetchNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to pin note.");
        }
    };

    const handleArchiveNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/archive`);
            setMessage("Note archived.");
            await fetchNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to archive note.");
        }
    };

    const handleTrashNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}/trash`);
            setMessage("Note moved to trash.");
            await fetchNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to trash note.");
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
        setEditForm({ title: "", description: "", reminderAt: "" });
    };

    const handleUpdateNote = async (noteId) => {
        try {
            await api.put(`/api/notes/${noteId}`, {
                title: editForm.title.trim(),
                description: editForm.description.trim(),
                reminderAt: editForm.reminderAt || null,
            });
            setMessage("Note updated.");
            setEditingNoteId(null);
            setEditForm({ title: "", description: "", reminderAt: "" });
            await fetchNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to update note.");
        }
    };

    const handleDeleteNote = async (noteId) => {
        if (!window.confirm("Permanently delete this note?")) return;
        try {
            await api.delete(`/api/notes/${noteId}`);
            setMessage("Note deleted.");
            await fetchNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to delete note.");
        }
    };

    const handleLabelSelect = (noteId, labelId) => setSelectedLabels({ ...selectedLabels, [noteId]: labelId });

    const handleAddLabelToNote = async (noteId) => {
        const labelId = selectedLabels[noteId];
        if (!labelId) return;
        try {
            await api.put(`/api/labels/${labelId}/notes/${noteId}`);
            await fetchNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to add label.");
        }
    };

    const handleRemoveLabelFromNote = async (noteId, labelId) => {
        try {
            await api.delete(`/api/labels/${labelId}/notes/${noteId}`);
            await fetchNotes();
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to remove label.");
        }
    };

    const handleSearchNotes = async (e) => {
        e.preventDefault();
        if (!searchKeyword.trim()) return;
        try {
            const response = await api.get(`/api/notes/search?keyword=${encodeURIComponent(searchKeyword.trim())}`);
            setNotes(response.data);
            setIsSearching(true);
        } catch (error) {
            setMessage(error.response?.data?.message || "Search failed.");
        }
    };

    const handleClearSearch = async () => {
        setSearchKeyword("");
        setIsSearching(false);
        setMessage("");
        await fetchNotes();
    };

    const formatReminder = (dateStr) => {
        if (!dateStr) return null;
        const d = new Date(dateStr);
        return d.toLocaleString("en-IN", { month: "short", day: "numeric", hour: "2-digit", minute: "2-digit" });
    };

    const pinnedNotes = notes.filter(n => n.pinned);
    const otherNotes = notes.filter(n => !n.pinned);

    return (
        <div className="app-layout">
            {/* TOP NAVBAR */}
            <nav className="topnav">
                <div className="topnav-logo">
                    <span>Fundoo<span className="logo-dot"> Notes</span></span>
                </div>

                <form className="topnav-search" onSubmit={handleSearchNotes}>
                    <i className="ti ti-search" aria-hidden="true"></i>
                    <input
                        type="text"
                        placeholder="Search your notes"
                        value={searchKeyword}
                        onChange={(e) => setSearchKeyword(e.target.value)}
                    />
                    {isSearching && (
                        <button type="button" className="icon-btn" onClick={handleClearSearch} title="Clear search">
                            <i className="ti ti-x"></i>
                        </button>
                    )}
                </form>

                <div className="topnav-actions">
                    <button className="icon-btn" title="Refresh" onClick={fetchNotes}>
                        <i className="ti ti-refresh"></i>
                    </button>
                    <button className="avatar-btn" onClick={handleLogout} title="Logout">
                        F
                    </button>
                </div>
            </nav>

            {/* SIDEBAR */}
            <aside className="sidebar">
                <button type="button" className="sidebar-link active">
                    <i className="ti ti-bulb" aria-hidden="true"></i>
                    <span>Notes</span>
                </button>
                <button type="button" className="sidebar-link" onClick={() => navigate("/archive")}>
                    <i className="ti ti-archive" aria-hidden="true"></i>
                    <span>Archive</span>
                </button>
                <button type="button" className="sidebar-link" onClick={() => navigate("/trash")}>
                    <i className="ti ti-trash" aria-hidden="true"></i>
                    <span>Trash</span>
                </button>
                <button type="button" className="sidebar-link" onClick={() => navigate("/labels")}>
                    <i className="ti ti-tag" aria-hidden="true"></i>
                    <span>Labels</span>
                </button>
                <button type="button" className="sidebar-link" onClick={() => navigate("/export")}>
                    <i className="ti ti-download" aria-hidden="true"></i>
                    <span>Export</span>
                </button>
                <button type="button" className="sidebar-link" onClick={() => navigate("/payments")}>
                    <i className="ti ti-credit-card" aria-hidden="true"></i>
                    <span>Payments</span>
                </button>
                <button type="button" className="sidebar-link" onClick={() => navigate("/attachments")}>
                    <i className="ti ti-paperclip" aria-hidden="true"></i>
                    <span>Attachments</span>
                </button>
            </aside>

            {/* MAIN CONTENT */}
            <main className="main-content">
                {message && (
                    <div className="dashboard-message" onClick={() => setMessage("")} style={{ cursor: "pointer" }}>
                        {message}
                    </div>
                )}

                {/* CREATE NOTE */}
                <form className="create-note-card" onSubmit={handleCreateNote}>
                    {isCreateExpanded && (
                        <input
                            type="text"
                            name="title"
                            placeholder="Title"
                            value={noteForm.title}
                            onChange={handleChange}
                        />
                    )}
                    <textarea
                        name="description"
                        placeholder="Take a note..."
                        rows={isCreateExpanded ? 3 : 1}
                        value={noteForm.description}
                        onChange={handleChange}
                        onFocus={() => setIsCreateExpanded(true)}
                        style={{ padding: isCreateExpanded ? "4px 16px 8px" : "16px" }}
                    />
                    {isCreateExpanded && (
                        <div className="create-note-footer">
                            <input
                                type="datetime-local"
                                name="reminderAt"
                                value={noteForm.reminderAt}
                                onChange={handleChange}
                                title="Set reminder"
                            />
                            <div style={{ display: "flex", gap: "4px" }}>
                                <button
                                    type="button"
                                    className="btn-close-note"
                                    onClick={() => { setIsCreateExpanded(false); setNoteForm({ title: "", description: "", reminderAt: "" }); }}
                                >
                                    Close
                                </button>
                                <button className="primary-small-btn" type="submit" disabled={loading}>
                                    {loading ? "Saving..." : "Done"}
                                </button>
                            </div>
                        </div>
                    )}
                </form>

                {/* PINNED NOTES */}
                {pinnedNotes.length > 0 && (
                    <>
                        <p className="notes-section-title">Pinned</p>
                        <div className="notes-grid">
                            {pinnedNotes.map(note => (
                                <NoteCard
                                    key={note.id}
                                    note={note}
                                    labels={labels}
                                    editingNoteId={editingNoteId}
                                    editForm={editForm}
                                    selectedLabels={selectedLabels}
                                    onPin={handlePinNote}
                                    onArchive={handleArchiveNote}
                                    onTrash={handleTrashNote}
                                    onEdit={startEditNote}
                                    onDelete={handleDeleteNote}
                                    onUpdate={handleUpdateNote}
                                    onCancelEdit={cancelEditNote}
                                    onEditChange={handleEditChange}
                                    onLabelSelect={handleLabelSelect}
                                    onAddLabel={handleAddLabelToNote}
                                    onRemoveLabel={handleRemoveLabelFromNote}
                                    formatReminder={formatReminder}
                                />
                            ))}
                        </div>
                    </>
                )}

                {/* OTHER NOTES */}
                {otherNotes.length > 0 && (
                    <>
                        {pinnedNotes.length > 0 && <p className="notes-section-title">Others</p>}
                        <div className="notes-grid">
                            {otherNotes.map(note => (
                                <NoteCard
                                    key={note.id}
                                    note={note}
                                    labels={labels}
                                    editingNoteId={editingNoteId}
                                    editForm={editForm}
                                    selectedLabels={selectedLabels}
                                    onPin={handlePinNote}
                                    onArchive={handleArchiveNote}
                                    onTrash={handleTrashNote}
                                    onEdit={startEditNote}
                                    onDelete={handleDeleteNote}
                                    onUpdate={handleUpdateNote}
                                    onCancelEdit={cancelEditNote}
                                    onEditChange={handleEditChange}
                                    onLabelSelect={handleLabelSelect}
                                    onAddLabel={handleAddLabelToNote}
                                    onRemoveLabel={handleRemoveLabelFromNote}
                                    formatReminder={formatReminder}
                                />
                            ))}
                        </div>
                    </>
                )}

                {/* EMPTY STATE */}
                {notes.length === 0 && (
                    <div className="notes-grid">
                        <div className="empty-state">
                            <i className="ti ti-bulb"></i>
                            <p>Notes you add appear here</p>
                        </div>
                    </div>
                )}
            </main>
        </div>
    );
}

function NoteCard({
    note, labels, editingNoteId, editForm, selectedLabels,
    onPin, onArchive, onTrash, onEdit, onDelete, onUpdate,
    onCancelEdit, onEditChange, onLabelSelect, onAddLabel, onRemoveLabel, formatReminder
}) {
    const isEditing = editingNoteId === note.id;

    return (
        <div className={`note-card ${note.pinned ? "pinned" : ""}`}>
            {isEditing ? (
                <>
                    <input className="edit-input" type="text" name="title" value={editForm.title} onChange={onEditChange} placeholder="Title" />
                    <textarea className="edit-textarea" name="description" value={editForm.description} onChange={onEditChange} placeholder="Note" rows={4} />
                    <input className="edit-input" type="datetime-local" name="reminderAt" value={editForm.reminderAt} onChange={onEditChange} />
                    <div className="edit-actions">
                        <button type="button" className="btn-cancel" onClick={onCancelEdit}>Cancel</button>
                        <button type="button" className="btn-save" onClick={() => onUpdate(note.id)}>Save</button>
                    </div>
                </>
            ) : (
                <>
                    {note.title && <h3>{note.title}</h3>}
                    <p>{note.description}</p>

                    {note.reminderAt && (
                        <div className="note-reminder">
                            <i className="ti ti-bell"></i>
                            {formatReminder(note.reminderAt)}
                        </div>
                    )}

                    {note.labels && note.labels.length > 0 && (
                        <div className="note-labels">
                            {note.labels.map(label => (
                                <span className="note-label-chip" key={label.id}>
                                    {label.name}
                                    <button type="button" onClick={() => onRemoveLabel(note.id, label.id)}>
                                        <i className="ti ti-x" style={{ fontSize: "11px" }}></i>
                                    </button>
                                </span>
                            ))}
                        </div>
                    )}

                    <div className="label-assign-row">
                        <select value={selectedLabels[note.id] || ""} onChange={(e) => onLabelSelect(note.id, e.target.value)}>
                            <option value="">Add label</option>
                            {labels.map(label => (
                                <option key={label.id} value={label.id}>{label.name}</option>
                            ))}
                        </select>
                        <button type="button" onClick={() => onAddLabel(note.id)}>Add</button>
                    </div>

                    <div className="note-hover-actions">
                        <button
                            type="button"
                            className={`note-action-btn ${note.pinned ? "active-pin" : ""}`}
                            onClick={() => onPin(note.id)}
                            title={note.pinned ? "Unpin" : "Pin"}
                        >
                            <i className="ti ti-pin"></i>
                        </button>
                        <button type="button" className="note-action-btn" onClick={() => onArchive(note.id)} title="Archive">
                            <i className="ti ti-archive"></i>
                        </button>
                        <button type="button" className="note-action-btn" onClick={() => onEdit(note)} title="Edit">
                            <i className="ti ti-pencil"></i>
                        </button>
                        <button type="button" className="note-action-btn" onClick={() => onTrash(note.id)} title="Move to trash">
                            <i className="ti ti-trash"></i>
                        </button>
                        <button type="button" className="note-action-btn danger" onClick={() => onDelete(note.id)} title="Delete permanently">
                            <i className="ti ti-trash-x"></i>
                        </button>
                    </div>
                </>
            )}
        </div>
    );
}

export default Dashboard;
