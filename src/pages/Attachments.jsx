import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

function Attachments() {
    const navigate = useNavigate();

    const [notes, setNotes] = useState([]);
    const [noteId, setNoteId] = useState("");
    const [file, setFile] = useState(null);
    const [attachments, setAttachments] = useState([]);

    const [message, setMessage] = useState("");
    const [uploading, setUploading] = useState(false);
    const [loadingAttachments, setLoadingAttachments] = useState(false);

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

    useEffect(() => {
        fetchNotes();
    }, []);

    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("message");
        navigate("/login");
    };

    const handleNoteChange = async (e) => {
        const selectedNoteId = e.target.value;
        setNoteId(selectedNoteId);
        setAttachments([]);
        setMessage("");

        if (selectedNoteId) {
            await fetchAttachmentsByNoteId(selectedNoteId);
        }
    };

    const fetchAttachmentsByNoteId = async (selectedNoteId) => {
        setLoadingAttachments(true);
        setMessage("");

        try {
            const response = await api.get(`/api/attachments/notes/${selectedNoteId}`);
            setAttachments(response.data);
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to load attachments."
            );
        } finally {
            setLoadingAttachments(false);
        }
    };

    const fetchAttachments = async () => {
        if (!noteId) {
            setMessage("Please select a note first.");
            return;
        }

        await fetchAttachmentsByNoteId(noteId);
    };

    const handleUploadAttachment = async (e) => {
        e.preventDefault();

        if (!noteId) {
            setMessage("Please select a note.");
            return;
        }

        if (!file) {
            setMessage("Please choose a file.");
            return;
        }

        setUploading(true);
        setMessage("");

        try {
            const formData = new FormData();
            formData.append("file", file);

            await api.post(`/api/attachments/notes/${noteId}`, formData, {
                headers: {
                    "Content-Type": "multipart/form-data",
                },
            });

            setFile(null);

            const fileInput = document.getElementById("attachment-file-input");
            if (fileInput) {
                fileInput.value = "";
            }

            setMessage("Attachment uploaded successfully.");
            await fetchAttachments();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to upload attachment."
            );
        } finally {
            setUploading(false);
        }
    };

    const handleDownloadAttachment = async (attachment) => {
        try {
            const response = await api.get(
                `/api/attachments/download/${attachment.id}`,
                {
                    responseType: "blob",
                }
            );

            const fileBlob = new Blob([response.data], {
                type: attachment.fileType || "application/octet-stream",
            });

            const downloadUrl = window.URL.createObjectURL(fileBlob);

            const link = document.createElement("a");
            link.href = downloadUrl;
            link.download = attachment.fileName || "attachment";
            document.body.appendChild(link);
            link.click();

            link.remove();
            window.URL.revokeObjectURL(downloadUrl);

            setMessage("Attachment downloaded successfully.");
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to download attachment."
            );
        }
    };

    const handleDeleteAttachment = async (attachmentId) => {
        const confirmDelete = window.confirm(
            "Are you sure you want to delete this attachment?"
        );

        if (!confirmDelete) {
            return;
        }

        try {
            await api.delete(`/api/attachments/${attachmentId}`);
            setMessage("Attachment deleted successfully.");
            await fetchAttachments();
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to delete attachment."
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

                    <button type="button" className="sidebar-link active">
                        Attachments
                    </button>
                </nav>
            </aside>

            <main className="main-content">
                <header className="topbar">
                    <div>
                        <h1>Attachments</h1>
                        <p>Select a note and manage its attachments</p>
                    </div>

                    <button type="button" className="logout-btn" onClick={handleLogout}>
                        Logout
                    </button>
                </header>

                {message && <div className="dashboard-message">{message}</div>}

                <section className="attachment-layout">
                    <div className="attachment-card">
                        <h2>Upload Attachment</h2>

                        <form onSubmit={handleUploadAttachment}>
                            <div className="form-group">
                                <label>Select Note</label>
                                <select value={noteId} onChange={handleNoteChange} required>
                                    <option value="">Select a note</option>

                                    {notes.map((note) => (
                                        <option key={note.id} value={note.id}>
                                            {note.title}
                                        </option>
                                    ))}
                                </select>
                            </div>

                            <div className="form-group">
                                <label>Select File</label>
                                <input
                                    id="attachment-file-input"
                                    type="file"
                                    onChange={(e) => setFile(e.target.files[0])}
                                    required
                                />
                            </div>

                            <button
                                type="submit"
                                className="primary-small-btn attachment-btn"
                                disabled={uploading}
                            >
                                {uploading ? "Uploading..." : "Upload File"}
                            </button>
                        </form>
                    </div>

                    <div className="attachment-card">
                        <h2>View Attachments</h2>

                        <p className="attachment-help">
                            Select a note from the dropdown. Attachments will load
                            automatically.
                        </p>

                        <button
                            type="button"
                            className="refresh-btn"
                            onClick={fetchAttachments}
                            disabled={loadingAttachments}
                        >
                            {loadingAttachments ? "Loading..." : "Refresh Attachments"}
                        </button>

                        <div className="attachments-list">
                            {!noteId ? (
                                <div className="empty-state small-empty">
                                    Select a note to view attachments.
                                </div>
                            ) : attachments.length === 0 ? (
                                <div className="empty-state small-empty">
                                    No attachments found for this note.
                                </div>
                            ) : (
                                attachments.map((attachment) => (
                                    <div className="attachment-item" key={attachment.id}>
                                        <div>
                                            <h3>{attachment.fileName}</h3>
                                            <p>{attachment.fileType}</p>
                                            <p>{attachment.fileSize} bytes</p>
                                        </div>

                                        <div className="attachment-actions">
                                            <button
                                                type="button"
                                                onClick={() => handleDownloadAttachment(attachment)}
                                            >
                                                Download
                                            </button>

                                            <button
                                                type="button"
                                                className="danger-btn"
                                                onClick={() => handleDeleteAttachment(attachment.id)}
                                            >
                                                Delete
                                            </button>
                                        </div>
                                    </div>
                                ))
                            )}
                        </div>
                    </div>
                </section>
            </main>
        </div>
    );
}

export default Attachments;